package ru.korus.service;

import org.springframework.stereotype.Service;
import ru.korus.model.SpringDao;


@Service
public class SpringDAOService {

    public String getName(){
        SpringDao sd = new SpringDao();
        return sd.getRecordName(1);
    }

}
