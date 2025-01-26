package com.teamkhaos.game.utils;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Temporizador {
    private int startHour = 12; // Hora inicial (12 PM)
    private int endHour = 6;   // Hora final (6 AM)
    private float timeElapsed = 0; // Tiempo transcurrido en segundos
    private float duration; // Duración total del juego en segundos
    private BitmapFont font; // Fuente para dibujar el texto del temporizador
    private boolean gameOver; // Indica si el juego ha terminado

    public Temporizador(float durationInMinutes) {
        this.duration = durationInMinutes * 60; // Convertir minutos a segundos
        font = new BitmapFont(); // Fuente predeterminada de libGDX
        this.gameOver = false; // Inicializar como no terminado
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public String getCurrentTime() {
        // Progreso del tiempo (0.0 a 1.0)
        float progress = Math.min(timeElapsed / duration, 1.0f); // Asegurarse de que no exceda 1.0

        // Calcular la hora actual según el progreso
        int currentHour = startHour + (int) Math.floor(progress * (startHour-endHour));
        if (currentHour > 12) currentHour -= 12; // Ajustar al formato de 12 horas

        // Determinar si es AM o PM
        String period = (currentHour >= 12 && currentHour < 6) ? "PM" : "AM";

        return currentHour + ":00 " + period;
    }

    public void update(float delta) {
        if (!gameOver) {
            timeElapsed += delta; // Incrementar tiempo transcurrido
            if (timeElapsed >= duration) {
                gameOver = true; // Marcar el juego como terminado
            }
        }
    }

    public void draw(SpriteBatch batch) {
        String currentTime = getCurrentTime();
        font.draw(batch, "Hora: " + currentTime, 690, 465); // Dibuja el texto en pantalla
    }

    public void dispose() {
        font.dispose(); // Liberar recursos
    }
}
