package prototypepattern;

public class ProtoTypeCitation {
    public static void main(String[] args) throws CloneNotSupportedException {
        Citation citation = new Citation("小五", "同学：在2016学年第一学期中表现优秀，被评为三好学生。", "韶关学院");
        citation.display();
        Citation clone = citation.clone();
        clone.setCollege("天津大学");
        clone.setName("小张");
        clone.display();
    }
}

class Citation implements Cloneable {
    private String name;
    private String info;
    private String college;

    void display() {
        System.out.println(name + info + college);
    }

    @Override
    protected Citation clone() throws CloneNotSupportedException {
        return (Citation) super.clone();
    }

    public Citation(String name, String info, String college) {
        this.name = name;
        this.info = info;
        this.college = college;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
}
