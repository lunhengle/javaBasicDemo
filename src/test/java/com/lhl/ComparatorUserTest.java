package com.lhl;

import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by lenovo on 2016/5/14.
 */
public class ComparatorUserTest {
    private List<User> userList = new ArrayList<>();

    @Before
    public void onSetUp() {
        User user1 = new User();
        user1.setAge(3);
        user1.setTimestamp(Timestamp.valueOf("2016-05-13 16:25:02"));
        userList.add(user1);

        User user2 = new User();
        user2.setAge(1);
        user2.setTimestamp(Timestamp.valueOf("2016-05-14 16:25:02"));
        userList.add(user2);

        User user3 = new User();
        user3.setAge(2);
        user3.setTimestamp(Timestamp.valueOf("2016-05-11 16:25:02"));
        userList.add(user3);

        User user4 = new User();
        user4.setAge(2);
        //user4.setTimestamp(Timestamp.valueOf("2016-05-17 16:25:02"));
        userList.add(user4);
    }

    @Test
    public void testComparator() {
        ComparatorUser comparatorUser = new ComparatorUser();
        Collections.sort(userList, comparatorUser);
        for (User user : userList) {
            System.out.println("after: age = " + user.getAge() + " timestamp = " + user.getTimestamp().toString());
        }
    }

    @Test
    public void testComparator1() {
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                Timestamp o2t = o2.getTimestamp() == null ? Timestamp.valueOf("1978-01-01 00:00:00") : o2.getTimestamp();
                Timestamp o1t = o1.getTimestamp() == null ? Timestamp.valueOf("1978-01-01 00:00:00") : o1.getTimestamp();
                return o2t.compareTo(o1t);
            }
        });
        for (User user : userList) {
            System.out.println("after: age = " + user.getAge() + " timestamp = " + (user.getTimestamp() == null ? "" : user.getTimestamp().toString()));
        }
    }

    @Test
    public void test() {
        Timestamp.valueOf("1978-01-01 00:00:00");
    }
}
