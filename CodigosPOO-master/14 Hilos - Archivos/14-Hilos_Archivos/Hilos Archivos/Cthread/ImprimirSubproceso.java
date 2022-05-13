package Cthread;

// la clase ImprimirSubproceso controla la ejecuci�n de los subprocesos
class ImprimirSubproceso extends Thread {
   private int tiempoInactividad;
    
   // asignar nombre a subproceso, llamando al constructor de la superclase
   public ImprimirSubproceso( String nombre )
   {
      super( nombre );
        
      // elegir tiempo de inactividad aleatorio entre 0 y 5 segundos
      tiempoInactividad = ( int ) ( Math.random() * 5001 );
   }        
    
   // el m�todo run es el c�digo a ejecutar por el nuevo subproceso
   public void run()
   {
      // colocar subproceso en inactividad durante el tiempo indicado por tiempoInactividad
      try {
         System.err.println( 
            getName() + " va a estar inactivo durante " + tiempoInactividad );
         Thread.sleep( tiempoInactividad );
      }
        
      // si el subproceso se interrumpi� durante su inactividad, imprimir rastreo de la pila
      catch ( InterruptedException excepcion ) {
         excepcion.printStackTrace();
      }
        
      // imprimir nombre del subproceso
      System.err.println( getName() + " termino su inactividad" );
    
   } // fin del m�todo run
    
} // fin de la clase ImprimirSubproceso
