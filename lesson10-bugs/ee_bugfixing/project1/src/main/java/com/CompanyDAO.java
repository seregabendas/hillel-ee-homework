package com;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
//please use Resource for spring inject
public class CompanyDAO {
    public List getAllCompanies() {
        return Arrays.asList(new Company(1, "addr1"), new Company(2, "addr2"));
    }
}
