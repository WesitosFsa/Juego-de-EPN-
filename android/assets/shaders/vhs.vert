attribute vec4 a_position;
attribute vec2 a_texCoord0;
uniform mat4 u_projTrans;

varying vec2 v_texCoord;

void main() {
    // Configurar las coordenadas de textura para el fragment shader
    v_texCoord = a_texCoord0;

    // Posición final del vértice
    gl_Position = u_projTrans * a_position;
}
