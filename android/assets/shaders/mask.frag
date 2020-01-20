#ifdef GL_ES
precision mediump float;
#endif

varying vec4 vColor;
varying vec2 vTexCoord;

uniform sampler2D u_texture;
uniform sampler2D u_mask;

uniform vec2 sizeMask;
uniform vec2 sizeTex;
uniform vec2 posMask;
uniform vec2 posTex;

void main() {
    vec4 texColor0 = texture2D(u_texture, vTexCoord);
    vec2 texCoordM = vec2((posTex.x - posMask.x)/sizeMask.x + vTexCoord.s * sizeTex.x/sizeMask.x, 1.0 - ((posTex.y - posMask.y + sizeTex.y)/sizeMask.y) + vTexCoord.t * sizeTex.y/sizeMask.y);
    float mask = texture2D(u_mask, texCoordM).a;
    gl_FragColor = vec4(vec3(vColor * texColor0), mask * texColor0.a);
}