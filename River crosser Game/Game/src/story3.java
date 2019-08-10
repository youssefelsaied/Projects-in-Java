import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class story3  implements ICrossingStrategy , ICommandStory{

    Farmer farmer1=new Farmer("p1-1.png","p1-2.png");
    Farmer farmer2=new Farmer("p2-1.png","p2-2.png");
    Farmer farmer3=new Farmer("p3-1.png","p3-2.png");
    Farmer farmer4=new Farmer("p4-1.png","p4-2.png");
    Farmer farmer5=new Farmer("p5-1.png","p5-2.png");

    raft raft=new raft();
    Stack undo =new Stack();
    Stack redo  =new Stack();
    int x1,x2,x3,x4,x5,x6,y1,y2,y3,y4,y5,y6,flagf1,flagf2,flagf3,flagf4,flagf5;
    public int score = 0;
    public story3(){
        flagf1=1;
        flagf2=1;
        flagf3=1;
        flagf4=1;
        flagf5=1;
        x1=390; y1=250;
        x2=280; y2=160;
        x3=250; y3=200;
        x4=220; y4=240;
        x5=190; y5=280;
        x6=160; y6=320;
    }

    public boolean canUndo(){
        if (undo.empty()==true)
            return false;
        else return true;
    }

    public   boolean canRedo(){
        if (redo.empty()==true)
            return false;
        else return true;

    }

    public void save()
    {
        final String xml = "story3.xml";
        Document dom;
        Element e = null;

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.newDocument();

            // create the root element
            Element rootEle = dom.createElement("story3");

            // create data elements and place them under root
            e = dom.createElement("x1");
            e.appendChild(dom.createTextNode(String.valueOf(x1)));
            rootEle.appendChild(e);

            e = dom.createElement("x2");
            e.appendChild(dom.createTextNode(String.valueOf(x2)));
            rootEle.appendChild(e);

            e = dom.createElement("x3");
            e.appendChild(dom.createTextNode(String.valueOf(x3)));
            rootEle.appendChild(e);

            e = dom.createElement("x4");
            e.appendChild(dom.createTextNode(String.valueOf(x4)));
            rootEle.appendChild(e);

            e = dom.createElement("x5");
            e.appendChild(dom.createTextNode(String.valueOf(x5)));
            rootEle.appendChild(e);

            e = dom.createElement("x6");
            e.appendChild(dom.createTextNode(String.valueOf(x6)));
            rootEle.appendChild(e);

            e = dom.createElement("y1");
            e.appendChild(dom.createTextNode(String.valueOf(y1)));
            rootEle.appendChild(e);

            e = dom.createElement("y2");
            e.appendChild(dom.createTextNode(String.valueOf(y2)));
            rootEle.appendChild(e);

            e = dom.createElement("y3");
            e.appendChild(dom.createTextNode(String.valueOf(y3)));
            rootEle.appendChild(e);

            e = dom.createElement("y4");
            e.appendChild(dom.createTextNode(String.valueOf(y4)));
            rootEle.appendChild(e);

            e = dom.createElement("y5");
            e.appendChild(dom.createTextNode(String.valueOf(y5)));
            rootEle.appendChild(e);

            e = dom.createElement("y6");
            e.appendChild(dom.createTextNode(String.valueOf(y6)));
            rootEle.appendChild(e);


            e = dom.createElement("flagf1");
            e.appendChild(dom.createTextNode(String.valueOf(flagf1)));
            rootEle.appendChild(e);

            e = dom.createElement("flagf2");
            e.appendChild(dom.createTextNode(String.valueOf(flagf2)));
            rootEle.appendChild(e);

            e = dom.createElement("flagf3");
            e.appendChild(dom.createTextNode(String.valueOf(flagf3)));
            rootEle.appendChild(e);

            e = dom.createElement("flagf4");
            e.appendChild(dom.createTextNode(String.valueOf(flagf4)));
            rootEle.appendChild(e);

            e = dom.createElement("flagf5");
            e.appendChild(dom.createTextNode(String.valueOf(flagf5)));
            rootEle.appendChild(e);


            dom.appendChild(rootEle);

            try {
                Transformer tr = TransformerFactory.newInstance().newTransformer();
                tr.setOutputProperty(OutputKeys.INDENT, "yes");
                tr.setOutputProperty(OutputKeys.METHOD, "xml");
                tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

                tr.transform(new DOMSource(dom),
                        new StreamResult(new FileOutputStream(xml)));

            } catch (TransformerException te) {
                System.out.println(te.getMessage());
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        } catch (ParserConfigurationException pce) {
            System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
        }
    }


    public void readxml(GraphicsContext gc) {
        final String xml_file = "story3.xml";
        ArrayList<Integer> rolev;
        rolev = new ArrayList<Integer>();
        Document dom;
        // Make an  instance of the DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // use the factory to take an instance of the document builder
            DocumentBuilder db = dbf.newDocumentBuilder();

            dom = db.parse(xml_file);
            Element doc = dom.getDocumentElement();

            x1 = Integer.parseInt(getTextValue(String.valueOf(x1), doc, "x1"));
            if (x1 != 0) {
                rolev.add(x1);
            }

            x2 = Integer.parseInt(getTextValue(String.valueOf(x2), doc, "x2"));
            if (x2 != 0) {
                rolev.add(x2);
            }

            x3 = Integer.parseInt(getTextValue(String.valueOf(x3), doc, "x3"));
            if (x3 != 0) {
                rolev.add(x3);
            }

            x4 = Integer.parseInt(getTextValue(String.valueOf(x4), doc, "x4"));
            if (x4 != 0) {
                rolev.add(x4);
            }

            x5 = Integer.parseInt(getTextValue(String.valueOf(x5), doc, "x5"));
            if (x5 != 0) {
                rolev.add(x5);
            }

            x6 = Integer.parseInt(getTextValue(String.valueOf(x6), doc, "x6"));
            if (x6 != 0) {
                rolev.add(x6);
            }





            y1 = Integer.parseInt(getTextValue(String.valueOf(y1), doc, "y1"));
            if (y1 != 0) {
                rolev.add(y1);
            }

            y2 = Integer.parseInt(getTextValue(String.valueOf(y2), doc, "y2"));
            if (y2 != 0) {
                rolev.add(y2);
            }

            y3 = Integer.parseInt(getTextValue(String.valueOf(y3), doc, "y3"));
            if (y3 != 0) {
                rolev.add(y3);
            }

            y4 = Integer.parseInt(getTextValue(String.valueOf(y4), doc, "y4"));
            if (y4 != 0) {
                rolev.add(y4);
            }

            y5 = Integer.parseInt(getTextValue(String.valueOf(y5), doc, "y5"));
            if (y5 != 0) {
                rolev.add(y5);
            }

            y6 = Integer.parseInt(getTextValue(String.valueOf(y6), doc, "y6"));
            if (y6 != 0) {
                rolev.add(y6);
            }




            flagf1 = Integer.parseInt(getTextValue(String.valueOf(flagf1), doc, "flagf1"));
            if (flagf1 != 0) {
                rolev.add(flagf1);
            }
            flagf2 = Integer.parseInt(getTextValue(String.valueOf(flagf2), doc, "flagf2"));
            if (flagf2 != 0) {
                rolev.add(flagf2);
            }
            flagf3 = Integer.parseInt(getTextValue(String.valueOf(flagf3), doc, "flagf3"));
            if (flagf3 != 0) {
                rolev.add(flagf3);
            }
            flagf4 = Integer.parseInt(getTextValue(String.valueOf(flagf4), doc, "flagf4"));
            if (flagf4 != 0) {
                rolev.add(flagf4);
            }



            flagf5 = Integer.parseInt(getTextValue(String.valueOf(flagf5), doc, "flagf5"));
            if (flagf5 != 0) {
                rolev.add(flagf5);
            }







        } catch (ParserConfigurationException pce) {
            System.out.println(pce.getMessage());
        } catch (SAXException se) {
            System.out.println(se.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

        draw(gc);


    }



    private String getTextValue(String def, Element doc, String tag) {
        String value = def;
        NodeList nl;
        nl = doc.getElementsByTagName(tag);
        if (nl.getLength() > 0 && nl.item(0).hasChildNodes()) {
            value = nl.item(0).getFirstChild().getNodeValue();
        }
        return value;
    }

    @Override
    public void mover(GraphicsContext gc,String s) {
        String whole=(x1)+" "+(x2)+" "+(x3)+" "+(x4)+" "+(x5)+" "+(x6)+" "+(y1)+" "+(y2)+" "+(y3)+" "+(y4)+" "+(y5)+" "+(y6)+" "+" "+(flagf1)+" "+(flagf2)+" "+(flagf3)+" "+(flagf4)+" "+(flagf5)+" ";
        undo.push(whole);
        score ++;
        if (s.equals("raft")) {
            if (x1 == 390) {
                x1 = 510;
                if (flagf1 == 1 && x2 == 400) {
                    x2 = 540;
                    flagf1 = 2;
                }
                if (flagf2 == 1 && x3 == 400) {
                    x3 = 540;
                    flagf2 = 2;
                }
                if (flagf3 == 1 && x4 == 400) {
                    x4 = 540;
                    flagf3 = 2;
                }

                if (flagf4 == 1 && x5 == 400) {
                    x5 = 540;
                    flagf4 = 2;
                }


                if (flagf5 == 1 && x6 == 400) {
                    x6 = 510;
                    flagf5 = 2;
                }
            } else if (x1 == 510) {
                x1 = 390;
                if (flagf1 == 2 && x2 == 540) {
                    x2 = 400;
                    flagf1 = 1;
                }
                if (flagf2 == 2 && x3 == 540) {
                    x3 = 400;
                    flagf2 = 1;
                }
                if (flagf3 == 2 && x4 == 540) {
                    x4 = 400;
                    flagf3 = 1;
                }

                if (flagf4 == 2 && x5 == 540) {
                    x5 = 400;
                    flagf4 = 1;
                }


                if (flagf5 == 2 && x6 == 510) {
                    x6 = 400;
                    flagf5 = 1;
                }
            }

            //raft right side (inside if)
            //position on right bank
            if (x2 == 540)
                x2 = 620;
            if (x3 == 540)
                x3 = 640;
            if (x4 == 540)
                x4 = 660;
            if (x5 == 540)
                x5 = 670;
            if (x6 == 510) {
                x6 = 650;
                y6 = 320;
            }

            //raft left side (inside if)
            //original
            if (x2 == 400)
                x2 = 280;
            if (x3 == 400)
                x3 = 250;
            if (x4 == 400)
                x4 = 220;
            if (x5 == 400)
                x5 = 190;
            if (x6 == 400)
                x6 = 160;
        }
        draw(gc);
        if(x2==620 && x3==640&& x4==660&& x5==670&& x6==650){
            AlarmBox.Display("CONGRATULATION");
        }
        String wholee=(x1)+" "+(x2)+" "+(x3)+" "+(x4)+" "+(x5)+" "+(x6)+" "+(y1)+" "+(y2)+" "+(y3)+" "+(y4)+" "+(y5)+" "+(y6)+" "+" "+(flagf1)+" "+(flagf2)+" "+(flagf3)+" "+(flagf4)+" "+(flagf5)+" ";
        redo.push(wholee);

    }

    public void draw(GraphicsContext gc2){
        gc2.clearRect(0,0,900,625);
        raft.render("BORED.png",gc2,x1,y1);
        if(x2<500)
            farmer1.render("p1-1.png",gc2,x2,y2);
        else
            farmer1.render("p1-2.png",gc2,x2,y2);

        if(x3<500)
            farmer2.render("p2-1.png",gc2,x3,y3);
        else
            farmer2.render("p2-2.png",gc2,x3,y3);
        if(x4<500)
            farmer3.render("p3-1.png",gc2,x4,y4);
        else
            farmer3.render("p3-2.png",gc2,x4,y4);
        if(x5<500)
            farmer4.render("p4-1.png",gc2,x5,y5);
        else
            farmer4.render("p4-2.png",gc2,x5,y5);
        if(x6<500)
            farmer5.render("p5-1.png",gc2,x6,y6);
        else
            farmer5.render("p5-2.png",gc2,x6,y6);


    }

    @Override

    public void movef(GraphicsContext gc,String s){
        String whole=(x1)+" "+(x2)+" "+(x3)+" "+(x4)+" "+(x5)+" "+(x6)+" "+(y1)+" "+(y2)+" "+(y3)+" "+(y4)+" "+(y5)+" "+(y6)+" "+" "+(flagf1)+" "+(flagf2)+" "+(flagf3)+" "+(flagf4)+" "+(flagf5)+" ";
        undo.push(whole);
        if (x1==390 && y1==250) {
            if (s.equals("f1") && flagf1 == 1) {
                if (x2 == 280)
                    x2 = 400;
                else
                    x2 = 280;
            }


            if (s.equals("f2") && flagf2 == 1) {
                if (x3 == 250)
                    x3 = 400;
                else
                    x3 = 250;
            }
            if (s.equals("f3") && flagf3 == 1) {
                if (x4 == 220)
                    x4 = 400;
                else
                    x4 = 220;
            }
            if (s.equals("f4") && flagf4 == 1) {
                if (x5 == 190)
                    x5 = 400;
                else
                    x5 =190;
            }
            if (s.equals("f5") && flagf5 == 1) {
                if (x6 == 160) {
                    x6 = 400;
                } else
                    x6 = 160;
            }

        }


        if(x1==510) {
            if (s.equals("f1") && flagf1 == 2) {
                if (x2 == 540)
                    x2 = 620;
                else
                    x2 = 540;
            }
            if (s.equals("f2") && flagf2 == 2) {
                if (x3 == 540)
                    x3 = 640;
                else
                    x3 = 540;
            }


            if (s.equals("f3") && flagf3 == 2) {
                if (x4 == 540)
                    x4 = 660;
                else
                    x4 = 540;
            }


            if (s.equals("f4") && flagf4 == 2) {
                if (x5 == 540)
                    x5 = 670;
                else
                    x5 = 540;
            }


            if (s.equals("f5") && flagf5 == 2) {
                if (x6 == 510) {
                    x6 = 650;
                    y6 = 320;
                } else {
                    x6 = 510;
                }
            }


        }
        draw(gc);

        String wholee=(x1)+" "+(x2)+" "+(x3)+" "+(x4)+" "+(x5)+" "+(x6)+" "+(y1)+" "+(y2)+" "+(y3)+" "+(y4)+" "+(y5)+" "+(y6)+" "+" "+(flagf1)+" "+(flagf2)+" "+(flagf3)+" "+(flagf4)+" "+(flagf5)+" ";


        try {

            redo.push(wholee);

        }catch (Exception e){
            System.out.println("error");
        }



    }
    public void resetGame(GraphicsContext gc){
        flagf1=1;
        flagf2=1;
        flagf3=1;
        flagf4=1;
        flagf5=1;
        x1=390; y1=250;
        x2=280; y2=160;
        x3=250; y3=200;
        x4=220; y4=240;
        x5=190; y5=280;
        x6=160; y6=320;
        score=0;
        draw(gc);
    }


    @Override
    public boolean isvalid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {


        if (leftBankCrossers.contains(farmer1)==false&& x2==280){
            leftBankCrossers.add(farmer1);
            if(rightBankCrossers.contains(farmer1))
            {
                rightBankCrossers.remove(farmer1);
            }
            else if(boatRiders.contains(farmer1))
            {
                boatRiders.remove(farmer1);
            }
        }


        if (rightBankCrossers.contains(farmer1)==false&& x2==620){
            rightBankCrossers.add(farmer1);
            if(leftBankCrossers.contains(farmer1)||boatRiders.contains(farmer1))
            {
                leftBankCrossers.remove(farmer1);
                boatRiders.remove(farmer1);
            }
        }


        if (boatRiders.contains(farmer1)==false&& (x2==540|| x2==400) ){
            boatRiders.add(farmer1);
            if(leftBankCrossers.contains(farmer1)||rightBankCrossers.contains(farmer1))
            {
                leftBankCrossers.remove(farmer1);
                rightBankCrossers.remove(farmer1);
            }
        }



        if (leftBankCrossers.contains(farmer2)==false&& x3==250){
            leftBankCrossers.add(farmer2);
            if(rightBankCrossers.contains(farmer2))
            {
                rightBankCrossers.remove(farmer2);
            }
            else if(boatRiders.contains(farmer2))
            {
                boatRiders.remove(farmer2);
            }
        }


        if (rightBankCrossers.contains(farmer2)==false&& x3==640){
            rightBankCrossers.add(farmer2);
            if(leftBankCrossers.contains(farmer2)||boatRiders.contains(farmer2))
            {
                leftBankCrossers.remove(farmer2);
                boatRiders.remove(farmer2);
            }
        }


        if (boatRiders.contains(farmer2)==false&& (x3==540|| x3==400) ){
            boatRiders.add(farmer2);
            if(leftBankCrossers.contains(farmer2)||rightBankCrossers.contains(farmer2))
            {
                leftBankCrossers.remove(farmer2);
                rightBankCrossers.remove(farmer2);
            }
        }


        if (leftBankCrossers.contains(farmer3)==false&& x4==220){
            leftBankCrossers.add(farmer3);
            if(rightBankCrossers.contains(farmer3))
            {
                rightBankCrossers.remove(farmer3);
            }
            else if(boatRiders.contains(farmer3))
            {
                boatRiders.remove(farmer3);
            }
        }


        if (rightBankCrossers.contains(farmer3)==false&& x4==660){
            rightBankCrossers.add(farmer3);
            if(leftBankCrossers.contains(farmer3)||boatRiders.contains(farmer3))
            {
                leftBankCrossers.remove(farmer3);
                boatRiders.remove(farmer3);
            }
        }


        if (boatRiders.contains(farmer3)==false&& (x4==540|| x4==400)){
            boatRiders.add(farmer3);
            if(leftBankCrossers.contains(farmer3)||rightBankCrossers.contains(farmer3))
            {
                leftBankCrossers.remove(farmer3);
                rightBankCrossers.remove(farmer3);
            }
        }


        if (leftBankCrossers.contains(farmer4)==false&& x5==190){
            leftBankCrossers.add(farmer4);
            if(rightBankCrossers.contains(farmer4))
            {
                rightBankCrossers.remove(farmer4);
            }
            else if(boatRiders.contains(farmer4))
            {
                boatRiders.remove(farmer4);
            }
        }


        if (rightBankCrossers.contains(farmer4)==false&& x5==670){
            rightBankCrossers.add(farmer4);
            if(leftBankCrossers.contains(farmer4)||boatRiders.contains(farmer4))
            {
                leftBankCrossers.remove(farmer4);
                boatRiders.remove(farmer4);
            }
        }


        if (boatRiders.contains(farmer4)==false&& (x5==540|| x5==400) ){
            boatRiders.add(farmer4);
            if(leftBankCrossers.contains(farmer4)||rightBankCrossers.contains(farmer4))
            {
                leftBankCrossers.remove(farmer4);
                rightBankCrossers.remove(farmer4);
            }
        }



        if (leftBankCrossers.contains(farmer5)==false&& x6==160){
            leftBankCrossers.add(farmer5);
            if(rightBankCrossers.contains(farmer5))
            {
                rightBankCrossers.remove(farmer5);
            }
            else if(boatRiders.contains(farmer5))
            {
                boatRiders.remove(farmer5);
            }
        }


        if (rightBankCrossers.contains(farmer5)==false&& x6==650){
            rightBankCrossers.add(farmer5);
            if(leftBankCrossers.contains(farmer5)||boatRiders.contains(farmer5))
            {
                leftBankCrossers.remove(farmer5);
                boatRiders.remove(farmer5);
            }
        }


        if (boatRiders.contains(farmer5)==false&& (x6==510|| x6==400)){
            boatRiders.add(farmer5);
            if(leftBankCrossers.contains(farmer5)||rightBankCrossers.contains(farmer5))
            {
                leftBankCrossers.remove(farmer5);
                rightBankCrossers.remove(farmer5);
            }
        }



        if (!boatRiders.contains(farmer1) && !boatRiders.contains(farmer2) && !boatRiders.contains(farmer3) && !boatRiders.contains(farmer4) && !boatRiders.contains(farmer5))
            return false;
        else if (boatRiders.size()>2)
            return false;

        if(boatRiders.contains(farmer1) &&  boatRiders.contains(farmer2) )
            return false;
        if(boatRiders.contains(farmer2) &&  boatRiders.contains(farmer3)  )
            return false;
        if(boatRiders.contains(farmer3) &&  boatRiders.contains(farmer4) )
            return false;
        if(boatRiders.contains(farmer4) &&  boatRiders.contains(farmer5) )
            return false;
        if(boatRiders.contains(farmer5) && boatRiders.contains(farmer1) )
            return false;


        if (leftBankCrossers.contains(farmer1) && leftBankCrossers.contains(farmer2)) {
            if (leftBankCrossers.contains(farmer4) )
                return true;
            else
                return false;
        }

        if (leftBankCrossers.contains(farmer2) && leftBankCrossers.contains(farmer3)) {
            if (  leftBankCrossers.contains(farmer5))
                return true;
            else
                return false;
        }

        if (leftBankCrossers.contains(farmer3) && leftBankCrossers.contains(farmer4)) {
            if (leftBankCrossers.contains(farmer1) )
                return true;
            else
                return false;
        }

        if (leftBankCrossers.contains(farmer4) && leftBankCrossers.contains(farmer5)) {
            if (leftBankCrossers.contains(farmer2) )
                return true;
            else
                return false;
        }
        if (leftBankCrossers.contains(farmer5) && leftBankCrossers.contains(farmer1)) {
            if (leftBankCrossers.contains(farmer3) )
                return true;
            else
                return false;
        }





        if (rightBankCrossers.contains(farmer1) && rightBankCrossers.contains(farmer2)) {
            if (rightBankCrossers.contains(farmer4) )
                return true;
            else
                return false;
        }

        if (rightBankCrossers.contains(farmer2) && rightBankCrossers.contains(farmer3)) {
            if (  rightBankCrossers.contains(farmer5))
                return true;
            else
                return false;
        }

        if (rightBankCrossers.contains(farmer3) && rightBankCrossers.contains(farmer4)) {
            if (rightBankCrossers.contains(farmer1) )
                return true;
            else
                return false;
        }

        if (rightBankCrossers.contains(farmer4) && rightBankCrossers.contains(farmer5)) {
            if (rightBankCrossers.contains(farmer2) )
                return true;
            else
                return false;
        }
        if (rightBankCrossers.contains(farmer5) && rightBankCrossers.contains(farmer1)) {
            if (rightBankCrossers.contains(farmer3) )
                return true;
            else
                return false;
        }

        else
            return true;
    }


    @Override
    public List<ICrosser> getInitialCrosser() {
        List listOfICrosser = new ArrayList();
        listOfICrosser.add(farmer1);
        listOfICrosser.add(farmer2);
        listOfICrosser.add(farmer3);
        listOfICrosser.add(farmer4);
        listOfICrosser.add(farmer5);
        return listOfICrosser;
    }
public int times=0;
    public void undo(GraphicsContext gc) {
        if (undo.empty() == false) {
            score--;
            String whole = (String) undo.pop();

            StringTokenizer positions =new StringTokenizer(whole," ");
            x1= Integer.parseInt(positions.nextToken());
            x2= Integer.parseInt(positions.nextToken());
            x3= Integer.parseInt(positions.nextToken());
            x4= Integer.parseInt(positions.nextToken());
            x5= Integer.parseInt(positions.nextToken());
            x6= Integer.parseInt(positions.nextToken());
            y1= Integer.parseInt(positions.nextToken());
            y2= Integer.parseInt(positions.nextToken());
            y3= Integer.parseInt(positions.nextToken());
            y4= Integer.parseInt(positions.nextToken());
            y5= Integer.parseInt(positions.nextToken());
            y6= Integer.parseInt(positions.nextToken());
            flagf1= Integer.parseInt(positions.nextToken());
            flagf2= Integer.parseInt(positions.nextToken());
            flagf3= Integer.parseInt(positions.nextToken());
            flagf4= Integer.parseInt(positions.nextToken());
            flagf5= Integer.parseInt(positions.nextToken());
            times++;
        }

        draw(gc);


    }



    Stack temp=new Stack();
    public void redo(GraphicsContext gc) {
        try {
            while (redo.isEmpty()==false)
                temp.push((String)redo.pop());

            if (temp.isEmpty() == false&&times>0) {
                score++;
                String whole2 = (String)temp.pop();
                StringTokenizer positions =new StringTokenizer(whole2," ");
                x1= Integer.parseInt(positions.nextToken());
                x2= Integer.parseInt(positions.nextToken());
                x3= Integer.parseInt(positions.nextToken());
                x4= Integer.parseInt(positions.nextToken());
                x5= Integer.parseInt(positions.nextToken());
                x6= Integer.parseInt(positions.nextToken());
                y1= Integer.parseInt(positions.nextToken());
                y2= Integer.parseInt(positions.nextToken());
                y3= Integer.parseInt(positions.nextToken());
                y4= Integer.parseInt(positions.nextToken());
                y5= Integer.parseInt(positions.nextToken());
                y6= Integer.parseInt(positions.nextToken());
                flagf1= Integer.parseInt(positions.nextToken());
                flagf2= Integer.parseInt(positions.nextToken());
                flagf3= Integer.parseInt(positions.nextToken());
                flagf4= Integer.parseInt(positions.nextToken());
                flagf5= Integer.parseInt(positions.nextToken());
            }}catch (Exception e){
            System.out.println("err2");
        }
        draw(gc);

    }



    @Override
    public String getInstructions() {
        String instruction = new String();
        instruction= "Five people want to get to the other side o the river," +
                "but each of them dislikes his immediate neighbors.\n" +
                "-the first person: dislikes the second and the fifth.\n" +
                "-the second person: dislikes the first and the third.\n" +
                "-the third person: dislikes the second and the fourth.\n" +
                "-the fourth person: dislikes the third and the fifth.\n" +
                "-the fifth person: dislikes the fourth and the first\n\n" + "Rules:\n" +
                "1.The boat can hold a maximum of two people\n" +
                "2.if two people hate each other they refuse to be either on the boat together, or in the same bank together without any person\n\n" +
                "How can they all get to the other side ?\n";
        return instruction;
    }
}