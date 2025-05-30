class Cleanser {
private String activeIngredient; //private
public void dilute(int percent) {// water-down}
public void apply(DirtyThing d) {// pour it on}
public void scrub(Brush b) {// watch it work}
}
public class Detergent extends Cleanser {
private String specialIngredient;
public void scrub(Brush b) {
// scrub gently, then
super.scrub(b); // the usual way
}
public void foam() { // make bubbles}
}