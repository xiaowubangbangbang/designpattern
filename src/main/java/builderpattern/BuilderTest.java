package builderpattern;

public class BuilderTest {
    public static void main(String[] args) {
        BuilderProduct build = BuilderProduct.builder().name("123").build();
        System.out.println(build.toString());
    }
}

class BuilderProduct {
    private String name;
    private String sex;

    BuilderProduct(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public static BuilderProduct.BuilderProductBuilder builder() {
        return new BuilderProduct.BuilderProductBuilder();
    }

    public static class BuilderProductBuilder {
        private String name;
        private String sex;

        BuilderProductBuilder() {
        }

        public BuilderProduct.BuilderProductBuilder name(String name) {
            this.name = name;
            return this;
        }

        public BuilderProduct.BuilderProductBuilder sex(String sex) {
            this.sex = sex;
            return this;
        }

        public BuilderProduct build() {
            return new BuilderProduct(this.name, this.sex);
        }

        public String toString() {
            return "BuilderProduct.BuilderProductBuilder(name=" + this.name + ", sex=" + this.sex + ")";
        }
    }
}
