package io.swagger.components;

import io.swagger.realityfamily.Repositories.CompanyRepository;
import io.swagger.realityfamily.Repositories.TransactionsRepository;
import io.swagger.realityfamily.Repositories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
    public class DataLoader implements ApplicationRunner {

        private ClientsRepository clientsRepository;
        private TransactionsRepository transactionsRepository;
        private CompanyRepository companyRepository;

        @Autowired
        public DataLoader(ClientsRepository clientsRepository, TransactionsRepository transactionsRepository, CompanyRepository companyRepository) {
            this.clientsRepository = clientsRepository;
            this.transactionsRepository = transactionsRepository;
            this.companyRepository = companyRepository;
        }

        public void run(ApplicationArguments args) {



        }
    }
