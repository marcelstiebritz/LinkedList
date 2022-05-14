import java.util.ArrayList;

public class ListeL<I extends Comparable<I>> {

    static class ElementL<K> {
        private K inhalt;           // Inhalt des Listenelements
        private ElementL<K> next;   // Verweis auf den Nachfolger
        public ElementL (K o) {
            inhalt = o;
            next = null;
        }
    }
    //[]

    private ElementL<I> head;       // Referenz auf den Anfang der Liste

    public ListeL () {
        head = null;
    }

    public ListeL (I o) {
        head = new ElementL<I>(o);
    }

    public ElementL<I> insertAtbeginning (I o) {   // am Anfang einf�gen
        ElementL<I> newEl = new ElementL<I>(o); // Erzuegt ein Element
        if (head == null) { // Liste ist noch leer
            head = newEl;
        }
        else {
            // [MezoMix][Cola][Fanta][Sprite][[
            // [Head][][Head.next]
            newEl.next = head;
            head = newEl;
        }
        return newEl;
    }

    public ElementL<I> insertAfter(I o, ElementL<I> pred) { // nach pred (Vorg�nger) einf�gen
        ElementL<I> newEl = new ElementL<I>(o);
        if (pred == null) { // am Anfang einf�gen
            newEl.next = head;
            head = newEl;
        }
        else {  // nach pred (Vorg�nger) einf�gen
           // [Fanta][Cola][Sprite][]
            // [Fanta][Cola][][Sprite]
            // [Fanta][Cola][MezoMix][Sprite]
            newEl.next = pred.next;
            pred.next = newEl;
        }
        return newEl;
    }

    public ElementL<I> insertBefore (I o, ElementL<I> post) {
        ElementL<I> newEl = new ElementL<I>(o);
        ElementL<I> currentEl = head;
        if (head == null|| head == post) {
            newEl.next = head;
            head = newEl;
        }else{
            // [Fanta(Head), -> Cola][Cola, -> Sprite][Sprite, ->null ][null]
            //
            while (currentEl != null && currentEl.next != /*Sprite*/post) {
                currentEl=currentEl.next;
            }if (currentEl!= null){
                currentEl.next=newEl;
            }
        }
        return newEl;

    }
    public ElementL<I> instert(I o, ElementL<I> post){
        ElementL<I> newEl = new ElementL<>(o);
        post.next= newEl;
        newEl.next=post;
        I temp = newEl.inhalt;
        newEl.inhalt= post.inhalt;
        return newEl;
    }

    public void remove (ElementL<I> pred) {  // Element nach pred (Vorg�nger) l�schen
        if (pred == null) // erstes Element l�schen
            head = head.next;
        else if (pred.next != null)  // Element nach pred (Vorg�nger) l�schen
            pred.next = pred.next.next;
    }

    public String toString() {
        String s = "(";
        ElementL<I> help = head;
        while (help != null && help.next != null) {
            s = s + help.inhalt + ", ";
            help = help.next;
        }
        if (help != null)
            s = s + help.inhalt;
        return s + ")";
    }

    // Test

    public static void main (String[] args) {


        ListeL<Integer> l = new ListeL<Integer>();



        l.insert(0);
        ElementL<Integer> eins = l.insert(new Integer(1));
        l.insert(3);
        System.out.println(l);
        l.insert(2, eins);  // nach eins einf�gen
        System.out.println(l);
        l.remove(eins);  // Nachfolger von eins l�schen
        System.out.println(l);
    }

}

