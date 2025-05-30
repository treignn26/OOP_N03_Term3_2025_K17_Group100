public class Detergent extends Cleanser {
    private String specialIngredient;
    public void scrub(Brush b) {
        // scrub gently, then
        super.scrub(b); // the usual way
    }
    public void foam() {}
}
