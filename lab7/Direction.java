public enum Direction{
    LEFT(-1,0),
    RIGHT(1,0),
    UP(0,1),
    DOWN(0,-1);

    private final int xVal;
    private final int yVal;
    Direction(int x, int y){
        this.xVal = x;
        this.yVal = y;
    }
    public int getX(){
        return this.xVal;
    }
    public int getY(){
        return this.yVal;
    }

    public String toString() {
		return "[" + xVal + ", " + yVal + "]";
	}
}
