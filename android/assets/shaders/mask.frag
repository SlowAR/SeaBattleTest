#ifdef GL_ES
precision mediump float;
#endif

varying vec4 vColor;
varying vec2 vTexCoord;

uniform sampler2D u_texture;

uniform vec2 u_sizeAtlasTex;
uniform vec2 u_texPos;
uniform vec2 u_texSize;
uniform vec2 u_maskPos;
uniform vec2 u_maskSize;

void main() {
    vec4 texColor0 = texture2D(u_texture, vTexCoord);
    //vec2 texCoordM = vec2((u_texPos.x - u_maskPos.x)/u_maskSize.x + vTexCoord.s * u_texSize.x/u_maskSize.x, 1.0 - ((u_texPos.y - u_maskPos.y + u_texSize.y)/u_maskSize.y) + vTexCoord.t * u_texSize.y/u_maskSize.y);
    vec2 texCoordM = vec2(0.1, 0.1);
    float mask = texture2D(u_texture, texCoordM).a;
    gl_FragColor = vec4(vec3(vColor * texColor0), mask * texColor0.a);
//    vec2 startMask = u_maskPos.xy / u_sizeAtlasTex.xy;
//    vec2 sizeMask = u_maskSize.xy / u_sizeAtlasTex.xy;
//    vec2 tc = vTexCoord;
//    vec4 col = vec4(0.0, 1.0, 0.0, 1.0);
//    col.a = texture2D(u_texture, tc).a;
//    gl_FragColor = col;
}