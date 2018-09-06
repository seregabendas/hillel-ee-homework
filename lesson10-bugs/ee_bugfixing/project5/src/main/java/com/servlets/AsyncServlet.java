package com.servlets;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//please try to test async servlet
@WebServlet(asyncSupported = true, urlPatterns = "/asyncServlet")
public class AsyncServlet extends HttpServlet {

    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final AsyncContext asyncContext = req.startAsync();

        asyncContext.addListener(new AsyncListener() {
            public void onComplete(AsyncEvent asyncEvent) throws IOException {
                //asyncContext.complete();
            }

            public void onTimeout(AsyncEvent asyncEvent) throws IOException {
                asyncContext.complete();
            }

            public void onError(AsyncEvent asyncEvent) throws IOException {
              asyncContext.complete();
            }

            public void onStartAsync(AsyncEvent asyncEvent) throws IOException {

            }
        });
        executorService.execute(new Thread() {
            public void run() {
                try {
                    Thread.sleep(2000);
                    asyncContext.getResponse().getWriter().println("hello from thread");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    asyncContext.complete();
                }
            }
        });
    }
}
