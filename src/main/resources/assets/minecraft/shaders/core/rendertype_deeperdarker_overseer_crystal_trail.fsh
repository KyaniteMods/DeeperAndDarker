#version 150

#define RESOLUTION 16.0

uniform float GameTime;

in vec2 texCoord;
out vec4 fragColor;

float lcg(float n, float modulus) {
    float a = 102.0;
    float seed = 2.0;

    float res = seed;
    float base = a;
    int exp = int(n);

    for(int i = 0; i < 12; i++) {
        if ((exp & 1) == 1) res = mod(res * base, modulus);
        base = mod(base * base, modulus);
        exp >>= 1;
    }
    return res / modulus;
}

void main() {
    vec2 gridPos = floor(texCoord * RESOLUTION);

    float pixelIndex = gridPos.y * RESOLUTION + gridPos.x;

    float timeInSeconds = GameTime * 24000.0 / 8.0;
    float frameIndex = floor(timeInSeconds);
    float elapsed = fract(timeInSeconds);

    float b1 = lcg(pixelIndex, frameIndex + 2000.0);
    float b2 = lcg(pixelIndex, frameIndex + 2001.0);

    float brightness = mix(b1, b2, elapsed);

    float roundedB = floor(brightness * 255.0 + 0.5);

    vec3 color;
    color.r = roundedB * 0.0196078431;
    color.g = roundedB * 0.3843137255;
    color.b = roundedB * 0.3647058824;

    fragColor = vec4(color / 255.0, 1.0);
}