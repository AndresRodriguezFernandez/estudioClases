package PSP.Trimestre1.Claude.Tema2.ContadorLocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Contador {
    private int valor = 0;
    private final Lock lock = new ReentrantLock();

    public void incrementar(){
        lock.lock();
        try{
            valor++;
        }finally{
            lock.unlock();
        }

    }

    public int getValor(){
        lock.lock();
        try{
            return valor;
        }finally{
            lock.unlock();
        }
    }
}
