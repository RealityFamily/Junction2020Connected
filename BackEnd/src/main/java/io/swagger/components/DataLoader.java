package io.swagger.components;

import io.swagger.model.*;
import io.swagger.realityfamily.Repositories.CompanyRepository;
import io.swagger.realityfamily.Repositories.TransactionsRepository;
import io.swagger.realityfamily.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.threeten.bp.*;

import java.util.*;

@Component
    public class DataLoader implements ApplicationRunner {

        private UsersRepository usersRepository;
        private TransactionsRepository transactionsRepository;
        private CompanyRepository companyRepository;

        @Autowired
        public DataLoader(UsersRepository usersRepository, TransactionsRepository transactionsRepository, CompanyRepository companyRepository) {
            this.usersRepository = usersRepository;
            this.transactionsRepository = transactionsRepository;
            this.companyRepository = companyRepository;
        }

        public void run(ApplicationArguments args) {



        }
    }
