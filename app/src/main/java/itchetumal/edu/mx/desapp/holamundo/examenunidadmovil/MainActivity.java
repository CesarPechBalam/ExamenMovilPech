package itchetumal.edu.mx.desapp.holamundo.examenunidadmovil;

        import android.content.Context;
        import android.graphics.Canvas;
        import android.graphics.Color;
        import android.graphics.Paint;
        import android.graphics.Path;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.MotionEvent;
        import android.view.View;
        import android.widget.LinearLayout;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    float circCoordX = 0, circCoordY = 0;
    String mensaje2 = " ", mensaje1 = " ";
    int Tiro, puntos;
    Path ruta = new Path();
    int jugador1,jugador2;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout = (LinearLayout) findViewById(R.id.layout1);
        Lienzo vista = new Lienzo(this);
        layout.addView(vista);
    }
    private String ContarTiros() {
        Tiro++;
        return String.valueOf(Tiro);
    }

    public void Turno(int tiro, int puntos){
        if(tiro == 10) {
            Toast.makeText(this,"Jugador 1",Toast.LENGTH_LONG).show();
            jugador1 =+ puntos;
        }
        if (tiro == 20){
            Toast.makeText(this,"Jugador 2",Toast.LENGTH_LONG).show();
            puntos = puntos - jugador1;
            jugador2 =+ puntos;

            if(jugador1 > jugador2){
                Toast.makeText(this,"Ganador Jugador 1",Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this,"Ganador Jugador 2",Toast.LENGTH_LONG).show();
            }
        }
    }
    class Lienzo extends View {

        int ancho;
        int alto;

        public Lienzo(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            Paint pincel = new Paint();

            ancho = canvas.getWidth();
            alto = canvas.getHeight();

            pincel.setAntiAlias(true);

            pincel.setTextSize(55);
            canvas.drawText(mensaje1, 0, this.getMeasuredHeight(), pincel);

            float x1 = ancho / 2;
            float y1 = alto / 2;

            pincel.setColor(Color.WHITE);
            canvas.drawCircle(x1, y1, 500, pincel);
            pincel.setColor(Color.BLACK);
            canvas.drawText("1",280,295,pincel);

            pincel.setColor(Color.WHITE);
            canvas.drawCircle(x1, y1, 450, pincel);
            pincel.setColor(Color.BLACK);
            canvas.drawText("2",320,340,pincel);

            pincel.setColor(Color.BLACK);
            canvas.drawCircle(x1, y1, 400, pincel);
            pincel.setColor(Color.WHITE);
            canvas.drawText("3",340,395,pincel);

            pincel.setColor(Color.BLACK);
            canvas.drawCircle(x1, y1, 350, pincel);
            pincel.setColor(Color.WHITE);
            canvas.drawText("4",360,440,pincel);

            pincel.setColor(Color.BLUE);
            canvas.drawCircle(x1, y1, 300, pincel);
            pincel.setColor(Color.BLACK);
            canvas.drawText("5",380,480,pincel);

            pincel.setColor(Color.BLUE);
            canvas.drawCircle(x1, y1, 250, pincel);
            pincel.setColor(Color.BLACK);
            canvas.drawText("6",400,530,pincel);

            pincel.setColor(Color.RED);
            canvas.drawCircle(x1, y1, 200, pincel);
            pincel.setColor(Color.BLACK);
            canvas.drawText("7",420,580,pincel);

            pincel.setColor(Color.RED);
            canvas.drawCircle(x1, y1, 150, pincel);
            pincel.setColor(Color.BLACK);
            canvas.drawText("8",440,620,pincel);

            pincel.setColor(Color.YELLOW);
            canvas.drawCircle(x1, y1, 100, pincel);
            pincel.setColor(Color.BLACK);
            canvas.drawText("9",460,665,pincel);

            pincel.setColor(Color.YELLOW);
            canvas.drawCircle(x1, y1, 50, pincel);
            pincel.setColor(Color.BLACK);
            canvas.drawText("10",460,740,pincel);

            pincel.setColor(Color.BLACK);
            canvas.drawText("Tiros: " + mensaje2, 50, 50, pincel);
            canvas.drawText("Puntos jugador 1: "+jugador1,50,150,pincel);
            canvas.drawText("Puntos jugador 2: "+jugador2,50,200,pincel);

        }

        public boolean onTouchEvent(MotionEvent evento) {

            circCoordX = evento.getX();
            circCoordY = evento.getY();

            if(Tiro<=19) {
                if (evento.getAction() == MotionEvent.ACTION_DOWN) {
                    ruta.moveTo(circCoordX, circCoordY);
                    mensaje1 = "Evento Down ";
                    mensaje2 = ContarTiros();


                    if (Math.sqrt(Math.pow(circCoordX - (ancho / 2), 2) + Math.pow(circCoordY - (alto / 2), 2)) <= 500) {
                        mensaje1 = "Diste click en el círculo blanco";
                        puntos = puntos + 1;
                    }
                    if (Math.sqrt(Math.pow(circCoordX - (ancho / 2), 2) + Math.pow(circCoordY - (alto / 2), 2)) <= 450) {
                        mensaje1 = "Diste click en el círculo blanco";
                        puntos = puntos + 1;
                    }
                    if (Math.sqrt(Math.pow(circCoordX - (ancho / 2), 2) + Math.pow(circCoordY - (alto / 2), 2)) <= 400) {
                        mensaje1 = "Diste click en el círculo negro";
                        puntos = puntos + 1;
                    }
                    if (Math.sqrt(Math.pow(circCoordX - (ancho / 2), 2) + Math.pow(circCoordY - (alto / 2), 2)) <= 350) {
                        mensaje1 = "Diste click en el círculo negro";
                        puntos = puntos + 1;
                    }
                    if (Math.sqrt(Math.pow(circCoordX - (ancho / 2), 2) + Math.pow(circCoordY - (alto / 2), 2)) <= 300) {
                        mensaje1 = "Diste click en el círculo azul";
                        puntos = puntos + 1;
                    }
                    if (Math.sqrt(Math.pow(circCoordX - (ancho / 2), 2) + Math.pow(circCoordY - (alto / 2), 2)) <= 250) {
                        mensaje1 = "Diste click en el círculo azul";
                        puntos = puntos + 1;
                    }
                    if (Math.sqrt(Math.pow(circCoordX - (ancho / 2), 2) + Math.pow(circCoordY - (alto / 2), 2)) <= 200) {
                        mensaje1 = "Diste click en el círculo rojo";
                        puntos = puntos + 1;
                    }
                    if (Math.sqrt(Math.pow(circCoordX - (ancho / 2), 2) + Math.pow(circCoordY - (alto / 2), 2)) <= 150) {
                        mensaje1 = "Diste click en el círculo rojo";
                        puntos = puntos + 1;
                    }
                    if (Math.sqrt(Math.pow(circCoordX - (ancho / 2), 2) + Math.pow(circCoordY - (alto / 2), 2)) <= 100) {
                        mensaje1 = "Diste click en el círculo amarillo";
                        puntos = puntos + 1;
                    }
                    if (Math.sqrt(Math.pow(circCoordX - (ancho / 2), 2) + Math.pow(circCoordY - (alto / 2), 2)) <= 50) {
                        mensaje1 = "Diste click en el blanco";
                        puntos = puntos + 1;
                    }
                    Turno(Tiro, puntos);
                }
                this.invalidate();
                return true;
            }
            return false;
        }
    }
}
