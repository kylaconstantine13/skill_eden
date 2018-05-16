package com.eve.skilleden;

import org.junit.Test;

import static org.junit.Assert.*;

public class StaticSkillsTest {

    @Test
    public void load() {
        StaticSkills list = new StaticSkills();
        list.load();
        for (SkillGroup sg : list.getByGroup()) {
            System.out.println(sg.getId() + ": " + sg.getName());
        }
    }
}