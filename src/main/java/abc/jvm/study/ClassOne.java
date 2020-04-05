package abc.jvm.study;

public class ClassOne {
    private String name ;

    private String birth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "ClassOne{" +
                "name='" + name + '\'' +
                ", birth='" + birth + '\'' +
                '}';
    }
}
