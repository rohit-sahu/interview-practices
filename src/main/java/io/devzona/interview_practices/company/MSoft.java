package io.devzona.interview_practices.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MSoft {

    @Autowired
    @Qualifier("abc2Impl")
    private Abc abc2Impl;
}

interface Abc {
    public void abc();
}

@Service
class AbcImpl implements Abc {

    @Override
    public void abc() {

    }
}

@Service("abc2Impl")
class Abc2Impl implements Abc {

    @Override
    public void abc() {

    }
}


interface IocContainer {
    Object getBean(String name);
}

class ApplicationContainer implements IocContainer {

    HashMap<String, Object> map = new HashMap<>();

    @Override
    public Object getBean(String name) {
        return null;
    }
}


