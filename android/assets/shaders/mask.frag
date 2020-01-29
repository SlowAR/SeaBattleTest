#ifdef GL_ES
precision mediump float;
#endif

varying vec4 vColor;
varying vec2 vTexCoord;

uniform sampler2D u_texture;

uniform vec2 u_sizeAtlasTex;
uniform vec2 u_textureRegionPos;
uniform vec2 u_textureRegionSize;
uniform vec2 u_maskRegionPos;
uniform vec2 u_maskRegionSize;

uniform vec2 u_screenSize;
uniform vec2 u_texturePos;
uniform vec2 u_textureSize;
uniform vec2 u_maskPos;
uniform vec2 u_maskSize;

void main() {
    vec4 textureColor = texture2D(u_texture, vTexCoord);
    //half working vec2 maskTexCoord = vec2((u_texturePos.x - u_maskPos.x)/u_maskSize.x + vTexCoord.s * u_textureSize.x/u_maskSize.x, 1.0 - ((u_texturePos.y - u_maskPos.y + u_textureSize.y)/u_maskSize.y) + vTexCoord.t * u_textureSize.y/u_maskSize.y);

//    vec4 maskTexColor = texture2D(u_texture, vec2((u_maskRegionPos.x + u_maskRegionSize.x * 0.5) / u_sizeAtlasTex.x, 1.0 - (u_maskRegionPos.y + u_maskRegionSize.y * 0.5) / u_sizeAtlasTex.y));
//    vec2 maskTexCoord = vec2((u_texturePos.x - u_maskPos.x)/u_maskSize.x + vTexCoord.s * u_textureSize.x/u_maskSize.x, 1.0 - ((u_texturePos.y - u_maskPos.y + u_textureSize.y)/u_maskSize.y) + vTexCoord.t * u_textureSize.y/u_maskSize.y);
//    vec4 maskColor = texture2D(u_texture, maskTexCoord);
//    if (maskColor != maskTexColor) {
//        textureColor = vec4(vec3(0.0, 1.0, 0.0), textureColor.a);
//    }
//    gl_FragColor = textureColor;

    vec2 textureCenterPos = vec2(u_texturePos.x + u_textureSize.x * 0.5, u_texturePos.y + u_textureSize.y * 0.5);
    vec2 maskCenterPos = vec2(u_maskPos.x + u_maskSize.x * 0.5, u_maskPos.y + u_maskSize.y * 0.5);

    vec2 maskTexCoordCoefficient = vec2((textureCenterPos.x - maskCenterPos.x) / (u_maskSize.x * 0.5 + u_textureSize.x * 0.5), (textureCenterPos.y - maskCenterPos.y) / (u_maskSize.y));
    vec2 texMaskStartPos = vec2(u_maskRegionPos.x / u_sizeAtlasTex.x, u_maskRegionPos.y / u_sizeAtlasTex.y);
    vec2 texMaskSize = vec2(u_maskRegionSize.x / u_sizeAtlasTex.x, u_maskRegionSize.y / u_sizeAtlasTex.y);

    vec2 startOffset = vec2(0.0, 0.0);
    vec2 endLimit = vec2(1.0, 1.0);
    if (maskTexCoordCoefficient.x > 1.0) {
        maskTexCoordCoefficient.x = 1.0;
    } else if (maskTexCoordCoefficient.x < -1.0) {
        maskTexCoordCoefficient.x = 1.0;
    } else {
        if (maskTexCoordCoefficient.x > 0.0) {
            startOffset = vec2(texMaskSize.x * maskTexCoordCoefficient.x, texMaskSize.y * maskTexCoordCoefficient.y);
        } else if (maskTexCoordCoefficient.x < 0.0) {
            endLimit = vec2(texMaskSize.x * (1.0 - maskTexCoordCoefficient.x), texMaskSize.y * (1.0 - maskTexCoordCoefficient.y));
        }
    }

    vec2 maskTexCoord = texMaskStartPos + vTexCoord * ((endLimit - startOffset) * texMaskSize);
    vec4 maskColor = texture2D(u_texture, maskTexCoord);
    if (maskColor.a > 0.0) {
        textureColor = vec4(vec3(1.0, 1.0, 1.0), textureColor.a);
    }
    gl_FragColor = maskColor;
}