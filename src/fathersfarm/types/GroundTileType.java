package fathersfarm.types;


public enum GroundTileType {
    GRASS ("grass.jpg"),
    SOIL ("soil.png");

    public final String texture;
    GroundTileType(String texture) {
        this.texture = texture;
    }
}
