package com.utn.spring.model;

import com.utn.spring.model.inter.IGetSalaryForStudent;

public class GetSalaryForStudentAImp implements IGetSalaryForStudent {

    @Override
    public Integer getSalary() {
        return new Integer(10);
    }
}
