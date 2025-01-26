#ifdef GL_ES
precision mediump float;
#endif

uniform sampler2D u_texture; // Textura base
uniform float u_time;        // Tiempo para animación

varying vec2 v_texCoord;     // Coordenadas de textura desde el vertex shader

void main() {
    vec2 uv = v_texCoord;

    // Añadir distorsión en UV usando sinusoides animadas
    float distortion = sin(uv.y * 40.0 + u_time * 5.0) * 0.02;
    uv.x += distortion;

    // Crear ruido animado basado en coordenadas UV y tiempo
    float noise = fract(sin(dot(uv + u_time * 0.1, vec2(12.9898, 78.233))) * 43758.5453) * 0.2;

    // Acceder al color base desde la textura
    vec4 color = texture2D(u_texture, uv);

    // Añadir ruido al color
    color.rgb += noise;

    gl_FragColor = color;
}

