package com.eve.skilleden;

import org.junit.Test;

import static org.junit.Assert.*;

public class StaticSkillsTest {

    @Test
    public void load() {
        int groupCount = 24;
        int skillCount = 490;
        int groupNameLength = 295;

        StaticSkills list = new StaticSkills();
        list.load();
        assertEquals(groupCount, list.getGroups().size());
        assertEquals(groupCount, list.getGroupsByName().size());
        assertEquals(skillCount, list.getSkillsById().size());
        assertEquals(skillCount, list.getSkillsByName().size());
        assertEquals(groupNameLength, list.groupNamesToString().length());
    }
}