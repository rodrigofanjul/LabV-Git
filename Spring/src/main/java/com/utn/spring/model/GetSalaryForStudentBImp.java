package com.utn.spring.model;

import com.utn.spring.model.inter.IGetSalaryForStudent;

public class GetSalaryForStudentBImp implements IGetSalaryForStudent {

    @Override
    public Integer getSalary() {
        return new Integer(15);
    }
}
