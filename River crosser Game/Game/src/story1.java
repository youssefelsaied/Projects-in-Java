import javafx.scene.canvas.GraphicsContext;
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
import java.util.concurrent.TimeUnit;

public class story1 implements ICrossingStrategy,ICommandStory{
 Farmer farmer=new Farmer("f1.png","f2.png");
 Image img=new Image("f1.png");
 Plant plant= new Plant("plant.png","plant.png");
 Herbivorous rabbit= new Herbivorous("Rabbit1.png","Rabbit2.png");
 Carnivorous tiger = new Carnivorous("Tiger1.png","Tiger2.png");
 raft raft=new raft();
 public int score =0;
 int x1,x2,x3,x4,x5,y1,y2,y3,y4,y5,flagr,flagp,flagt,flagf;
 Stack undo =new Stack();
 Stack redo  =new Stack();
 public story1(){
  flagf=1;
  flagr=1;
  flagt=1;flagp=1;
  x1=390;
  x2=320;
  x3=290;x4=230;x5=150;y1=250;y2=250;y3=240;y4=400;y5=450;
 }


 public boolean canUndo(){
  if (undo.empty()==true)
   return false;
   else return true;
  }

 public boolean canRedo(){
   if (redo.empty()==true)
    return false;
   else return true;

  }

 public void save() {
  final String xml = "story1.xml";
  Document dom;
  Element e = null;

  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
  try {

   DocumentBuilder db = dbf.newDocumentBuilder();
   dom = db.newDocument();

   // create the root element
   Element rootEle = dom.createElement("laststory");

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

   e = dom.createElement("flagf");
   e.appendChild(dom.createTextNode(String.valueOf(flagf)));
   rootEle.appendChild(e);

   e = dom.createElement("flagr");
   e.appendChild(dom.createTextNode(String.valueOf(flagr)));
   rootEle.appendChild(e);

   e = dom.createElement("flagt");
   e.appendChild(dom.createTextNode(String.valueOf(flagt)));
   rootEle.appendChild(e);

   e = dom.createElement("flagp");
   e.appendChild(dom.createTextNode(String.valueOf(flagp)));
   rootEle.appendChild(e);



   dom.appendChild(rootEle);

   try {
    Transformer tr = TransformerFactory.newInstance().newTransformer();
    tr.setOutputProperty(OutputKeys.INDENT, "yes");
    tr.setOutputProperty(OutputKeys.METHOD, "xml");
    tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
//    tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "roles.dtd");
//    tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

    // send DOM to file
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
  final String xml_file = "story1.xml";
  ArrayList<Integer> rolev;
  rolev = new ArrayList<Integer>();
  Document dom;
  // Make an  instance of the DocumentBuilderFactory
  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
  try {
   // use the factory to take an instance of the document builder
   DocumentBuilder db = dbf.newDocumentBuilder();
   // parse using the builder to get the DOM mapping of the
   // XML file
  // System.out.println( Files.readAllLines(Paths.get(xml_file)));
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

   flagf = Integer.parseInt(getTextValue(String.valueOf(flagf), doc, "flagf"));
   if (flagf != 0) {
    rolev.add(flagf);
   }

   flagr = Integer.parseInt(getTextValue(String.valueOf(flagr), doc, "flagr"));
   if (flagr != 0) {
    rolev.add(flagr);
   }

   flagt = Integer.parseInt(getTextValue(String.valueOf(flagt), doc, "flagt"));
   if (flagt != 0) {
    rolev.add(flagt);
   }

   flagp = Integer.parseInt(getTextValue(String.valueOf(flagp), doc, "flagp"));
   if (flagp != 0) {
    rolev.add(flagp);
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






 Farmer fg=new Farmer("f1.png","f2.png");
public void sleep(){
 try {
   wait(1000);
 }
 catch (InterruptedException e) {
  e.printStackTrace();
 }
}
 public void draw(GraphicsContext gc){
  gc.clearRect(0,0,900,625);
  raft.render("BORED.png",gc,x1,y1);
  if(x2<500)
   rabbit.render("Rabbit1.png",gc,x2,y2);
  else
   rabbit.render("Rabbit2.png",gc,x2,y2);

  if(x3<500)
   farmer.render("f1.png",gc,x3,y3);
  else
   farmer.render("f2.png",gc,x3,y3);plant.render("plant.png",gc,x4,y4);

  if(x5<500)
   tiger.render("Tiger1.png",gc,x5,y5);
  else
   tiger.render("Tiger2.png",gc,x5,y5);

  if(x4<500)
   plant.render("plant.png",gc,x4,y4);
  else
   plant.render("plant.png",gc,x4,y4);
 }

 public void movef(GraphicsContext gc,String s){
  String whole=(x1)+" "+(x2)+" "+(x3)+" "+(x4)+" "+(x5)+" "+(y1)+" "+(y2)+" "+(y3)+" "+(y4)+" "+(y5)+" "+(flagf)+" "+(flagr)+" "+(flagt)+" "+(flagp)+" ";
  undo.push(whole);

  if(s.equals("f")&&flagf==1){
   if(x3==290 && x1==390) {
    x3 = 400;
   }
   else{
    x3=290;
   }
  }
  if(s.equals("r")&&flagr==1){
   if(x2==320 && x1==390)
   {
    x2=420;
   }
   else
    {
    x2=320;
   }
  }

  if(s.equals("t")&&flagt==1){
   if(x5==150 && x1==390) {
    x5 = 390;
    y5=350;
   }
   else
   {
    x5=150;
    y5=450;
   }
  }
  if(s.equals("p")&&flagp==1){
   if(x4==230 && x1==390){
    x4=390;}
   else{
    x4=230;}
  }


  if(s.equals("f")&&flagf==2){
   if(x3==550 && x1==510) {
    x3 = 700;
   }
   else{
    x3=550;
    flagf=2;
   }
  }
  else ;

  if(s.equals("r")&&flagr==2){
   if(x2==510 && x1==510){
    x2=650;
   }
   else if(x2==650&& x1==510){
    x2=510;
   }
  }

  if(s.equals("t")&&flagt==2){
   if(x5==510 && x1==510) {
    x5 = 700;
    //y5=550;
   }
   else if(x5==700 && x1==510)
   {
    x5=510;
    //y5=350;
   }
  }

  if(s.equals("p")&&flagp==2){
   if(x4==510 && x1==510){
    x4=700;
   }
   else if(x4==700&& x1==510){
    x4=510;
   }
  }
  else;
  draw(gc);

  String wholee=(x1)+" "+(x2)+" "+(x3)+" "+(x4)+" "+(x5)+" "+(y1)+" "+(y2)+" "+(y3)+" "+(y4)+" "+(y5)+" "+(flagf)+" "+(flagr)+" "+(flagt)+" "+(flagp)+" ";

  try {

   redo.push(wholee);

  }catch (Exception e){
   System.out.println("eroor");
  }

 }

 public void mover(GraphicsContext gc,String s) {
  String whole=(x1)+" "+(x2)+" "+(x3)+" "+(x4)+" "+(x5)+" "+(y1)+" "+(y2)+" "+(y3)+" "+(y4)+" "+(y5)+" "+(flagf)+" "+(flagr)+" "+(flagt)+" "+(flagp)+" ";
  undo.push(whole);
  //redo.push(whole);
  score++;
  if (s.equals("raft")&&x1 == 390) {

   x1 = 510;


   if (flagr == 1 && x2 == 420) {
    flagr = 2;
    x2 = 510;
   }

   if (flagf == 1 && x3 == 400) {
    x3 = 550;
    flagf = 2;
   }

   if (flagp == 1 && x4 == 390) {
    x4 = 510;
    flagp = 2;
   }

   if (flagt == 1 && x5 == 390) {
    flagt = 2;
    x5 = 510;
   }

  }
 else if (x1==510) {
   x1 = 390;
   if (flagr == 2 && x2 == 510) {
    flagr = 1;
    x2 = 420;
   }

   if (flagf == 2 && x3 == 550) {
    x3 = 400;
    flagf = 1;
   }

   if (flagp == 2 && x4 == 510) {
    x4 = 390;
    flagp = 1;
   }


   if (flagt == 2 && x5 == 510) {
    flagt = 1;
    x5 = 390;
   }
 }

 if(x2==510)
   x2=650;
  if(x3==550)
   x3=700;
  if(x4==510)
   x4=700;
  if(x5==510)
   x5=700;
  if(x2==420)
   x2=320;
  if(x3==400)
   x3=290;
  if(x4==390)
   x4=230;
  if(x5==390&&y5==350)
  {
   x5=150;
   y5=450;
  }

  draw(gc);
  if(x2==650 && x3==700&& x4==700&& x5==700){
   AlarmBox.Display("CONGRATULATION");
  }
  String wholee=(x1)+" "+(x2)+" "+(x3)+" "+(x4)+" "+(x5)+" "+(y1)+" "+(y2)+" "+(y3)+" "+(y4)+" "+(y5)+" "+(flagf)+" "+(flagr)+" "+(flagt)+" "+(flagp)+" ";
  redo.push(wholee);



 }


 public void resetGame(GraphicsContext gc){
  flagf=1;
  flagr=1;
  flagt=1;flagp=1;
  x1=390; y1=250;
  x2=320; y2=250;
  x3=290; y3=240;
  x4=230; y4=400;
  x5=150; y5=450;
  score =0;





  draw(gc);
 }

 @Override
 public boolean isvalid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {

  if(x2==320&&leftBankCrossers.contains(rabbit)==false)
  {
   leftBankCrossers.add(rabbit);

   if(rightBankCrossers.contains(rabbit))
   {
    rightBankCrossers.remove(rabbit);
   }
   else if(boatRiders.contains(rabbit))
   {
    boatRiders.remove(rabbit);
   }
   else;

  }

  if(x3==290&&leftBankCrossers.contains(farmer)==false)
  {
   leftBankCrossers.add(farmer);
   if(rightBankCrossers.contains(farmer))
   {
    rightBankCrossers.remove(farmer);
   }
   else if(boatRiders.contains(farmer))
   {
    boatRiders.remove(farmer);
   }
   else;
  }
  if(x4==230&&leftBankCrossers.contains(plant)==false)
  {
   leftBankCrossers.add(plant);
   if(rightBankCrossers.contains(plant))
   {
    rightBankCrossers.remove(plant);
   }
   else if(boatRiders.contains(plant))
   {
    boatRiders.remove(plant);
   }
   else;
  }
  if(x5==150&&leftBankCrossers.contains(tiger)==false)
  {
   leftBankCrossers.add(tiger);

   if(rightBankCrossers.contains(tiger))
   {
    rightBankCrossers.remove(tiger);
   }
   else if(boatRiders.contains(tiger))
   {
    boatRiders.remove(tiger);
   }
   else;
  }

  if((x2==420||x2==510)&&boatRiders.contains(rabbit)==false)
  {
   boatRiders.add(rabbit);
   if(leftBankCrossers.contains(rabbit)||rightBankCrossers.contains(rabbit))
   {
    leftBankCrossers.remove(rabbit);
    rightBankCrossers.remove(rabbit);
   }
   else ;
  }
  if((x3==400||x3==550)&&boatRiders.contains(farmer)==false)
  {
   boatRiders.add(farmer);
   if(leftBankCrossers.contains(farmer)||rightBankCrossers.contains(farmer))
   {
    leftBankCrossers.remove(farmer);
    rightBankCrossers.remove(farmer);
   }
   else;
  }
  if((x4==390||x4==510)&&boatRiders.contains(plant)==false)
  {
   boatRiders.add(plant);
   if(leftBankCrossers.contains(plant)||rightBankCrossers.contains(plant))
   {
    leftBankCrossers.remove(plant);
    rightBankCrossers.remove(plant);
   }
   else;
  }
  if((x5==390||x5==510)&&boatRiders.contains(tiger)==false)
  {
   boatRiders.add(tiger);
   if(leftBankCrossers.contains(tiger)||rightBankCrossers.contains(tiger))
   {
    leftBankCrossers.remove(tiger);
    rightBankCrossers.remove(tiger);
   }
   else;
  }

  if(x2==650&&rightBankCrossers.contains(rabbit)==false)
  {
   rightBankCrossers.add(rabbit);
   if(leftBankCrossers.contains(rabbit)||boatRiders.contains(rabbit))
   {
    leftBankCrossers.remove(rabbit);
    boatRiders.remove(rabbit);
   }
   else;
  }
  if(x3==700&&rightBankCrossers.contains(farmer)==false)
  {
   rightBankCrossers.add(farmer);
   if(leftBankCrossers.contains(farmer)||boatRiders.contains(farmer))
   {
    leftBankCrossers.remove(farmer);
    boatRiders.remove(farmer);
   }
   else;

  }
  if(x4==700&&rightBankCrossers.contains(plant)==false)
  {
   rightBankCrossers.add(plant);
   if(leftBankCrossers.contains(plant)||boatRiders.contains(plant))
   {
    leftBankCrossers.remove(plant);
    boatRiders.remove(plant);
   }
   else;
  }
  if(x5==700&&rightBankCrossers.contains(tiger)==false)
  {
   rightBankCrossers.add(tiger);
   if(leftBankCrossers.contains(tiger)||boatRiders.contains(tiger))
   {
    leftBankCrossers.remove(tiger);
    boatRiders.remove(tiger);
   }
   else;
  }


  if (!boatRiders.contains(farmer))
   return false;
  else if (boatRiders.size()>2)
   return false;
  else if (rightBankCrossers.contains(tiger) && rightBankCrossers.contains(rabbit))
   return false;
  else if (rightBankCrossers.contains(rabbit) && rightBankCrossers.contains(plant))
   return false;
  else if (leftBankCrossers.contains(tiger) && leftBankCrossers.contains(rabbit))
   return false;
  else if (leftBankCrossers.contains(rabbit) && leftBankCrossers.contains(plant))
   return false;
  else
   return true;

 }

 @Override
 public List<ICrosser> getInitialCrosser() {
  List listOfICrosser = new ArrayList();
  listOfICrosser.add(farmer);
  listOfICrosser.add(plant);
  listOfICrosser.add(rabbit);
  listOfICrosser.add(tiger);
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
   y1= Integer.parseInt(positions.nextToken());
   y2= Integer.parseInt(positions.nextToken());
   y3= Integer.parseInt(positions.nextToken());
   y4= Integer.parseInt(positions.nextToken());
   y5= Integer.parseInt(positions.nextToken());
   flagf= Integer.parseInt(positions.nextToken());
   flagr= Integer.parseInt(positions.nextToken());
   flagt= Integer.parseInt(positions.nextToken());
   flagp= Integer.parseInt(positions.nextToken());
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
   y1= Integer.parseInt(positions.nextToken());
   y2= Integer.parseInt(positions.nextToken());
   y3= Integer.parseInt(positions.nextToken());
   y4= Integer.parseInt(positions.nextToken());
   y5= Integer.parseInt(positions.nextToken());
   flagf= Integer.parseInt(positions.nextToken());
   flagr= Integer.parseInt(positions.nextToken());
   flagt= Integer.parseInt(positions.nextToken());
   flagp= Integer.parseInt(positions.nextToken());


  }}catch (Exception e){
 System.out.println("err2");
  }
  draw(gc);
 }

 @Override
 public String getInstructions() {
  String instruction = new String();
  instruction=
          "A farmer wants to cross a river and take with him a carnivorous, a herbivorous and plant.\n \n" + "Rules: \n" +
                  "1.The farmer is the only one who can sail the boat. He can only take one passenger, in addition to himself.\n" +
                  "2.You can not leave any two crossers on the same bank if they can harm(eat) each other\n\n" +
                  "How can the farmer get across the river with all the 2 animals and the plant without any losses?";
  return instruction;
 }
}
