package src.domain.card;

public enum Type {
    SPADE("스페이스"),
    DIAMOND("다이아몬드"),
    HEART("하트"),
    CLUB("클로버");


    private final String typename;

    Type(String name){
        this.typename = name;
    }

    public String getTypeName(){
        return typename;
    }

}
