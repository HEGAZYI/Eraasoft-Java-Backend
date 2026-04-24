package Java911.P4;

public class EntityClass {
    private int id;
    private String name;

    public EntityClass(int id, String name) {
        setId(id);
        setName(name);
    }


    private void setId(int id) {
        if (id > 0) {
            this.id = id;
        }else{
            throw new IllegalArgumentException("id can't be negative");
        }
    }

    private void setName(String name) {
        if (name != null ) {
            this.name = name;
        }else {
            throw new IllegalArgumentException("name can't be null");
        }
    }

    public void printBasicData(){
        System.out.println("id: " + id);
        System.out.println("name: " + name);
    }
}
