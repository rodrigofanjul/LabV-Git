package com.utn.spring.model;

import com.utn.spring.model.inter.IGetSalaryForEmployer;

public class GetSalaryForEmployerImp implements IGetSalaryForEmployer {

    @Override
    public Integer getSalary() {
        return new Integer(20);
    }
}
