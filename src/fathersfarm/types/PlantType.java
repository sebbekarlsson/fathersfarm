package fathersfarm.types;


public enum PlantType {
    FLOWER_RED ("red_flower.png"),
    FLOWER_WHITE ("white_flower.png");

    public final String texture;
    PlantType(String texture) {
        this.texture = texture;
    }
}
