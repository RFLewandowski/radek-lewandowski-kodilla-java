package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {

        LocalDate ld1 = LocalDate.of(2011, 1, 1);
        LocalDate ld2 = LocalDate.of(2000, 12, 1);
        LocalDate ld3 = LocalDate.of(1988, 2, 1);
        LocalDate ld4 = LocalDate.of(1900, 4, 1);
        LocalDate ld5 = LocalDate.of(1987, 2, 1);
        LocalDate ld6 = LocalDate.of(1960, 12, 1);
        LocalDate ld7 = LocalDate.of(1991, 9, 1);
        LocalDate ld8 = LocalDate.of(1999, 11, 1);
        LocalDate ld9 = LocalDate.of(1939, 1, 1);

        List<ForumUser> forumUsers = new ArrayList<>();

        forumUsers.add(new ForumUser(1, "Johny Bravo1", 'M', ld1, 1));
        forumUsers.add(new ForumUser(2, "Johny Bravo2", 'F', ld2, 1000));
        forumUsers.add(new ForumUser(3, "Johny Bravo3", 'M', ld3, 999));
        forumUsers.add(new ForumUser(4, "Johny Bravo4", 'F', ld4, 12));
        forumUsers.add(new ForumUser(5, "Johny Bravo5", 'M', ld5, 5657));
        forumUsers.add(new ForumUser(6, "Johny Bravo6", 'M', ld6, 2));
        forumUsers.add(new ForumUser(7, "Johny Bravo7", 'F', ld7, 20));
        forumUsers.add(new ForumUser(8, "Johny Bravo8", 'F', ld8, 99));
        forumUsers.add(new ForumUser(9, "Johny Bravo9", 'F', ld9, 3));

        Forum forum = new Forum(forumUsers);


        Map<Integer, ForumUser> theResultMapOfUsers =
                forum.getUserList()
                        .stream()
                        .filter(forumUser -> forumUser.getSex() == 'M')
                        .filter(forumUser -> forumUser.getBirthDate().getYear() < LocalDate.now().getYear() - 20)
                        .filter(forumUser -> forumUser.getPublishedPostsCount() > 1)
                        .collect(Collectors.toMap(ForumUser::getUserID, forumUser -> forumUser));

        theResultMapOfUsers
                .entrySet()
                .stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}