package org.example;

import java.util.List;

public enum Word {
    SOFTWARE("software", List.of("back end", "backend", "back-end", "full stack", "full-stack", "frontend", "front end", "front-end", "java", "ruby", "python", "c+", "c++", "c")),
    ENGINEER("engineer", List.of("developer")),
    ACCOUNTANT("accountant", List.of("bean counter", "money person")),
    ARCHITECT("architect", List.of("building artist","george costanza")),
    EMPTY_STRING("", List.of("junior", "senior", "chief", "apprentice", "trainee", "intern"));

    public final String label;
    public final List<String> aliases;


    Word(String label, List<String> aliases) {
        this.label = label;
        this.aliases = aliases;
    }
}
