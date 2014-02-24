#pragma once

#include <glm/glm.hpp>
#include <blib/RenderState.h>
#include <map>


namespace blib { class ResourceManager; class Shader; class Renderer; };
class Map;

class MapRenderer
{
private:
	blib::ResourceManager* resourceManager;
	blib::RenderState gndRenderState;
	blib::VBO* gndVbo;
	std::map<int, std::pair<int, int> > gndVertIndices;
public:
	glm::mat4 cameraMatrix;

	bool drawShadows;
	bool drawObjects;
	bool drawTextureGrid;
	bool drawObjectGrid;
	bool drawQuadTree;

	void init( blib::ResourceManager* resourceManager );

	void render(blib::Renderer* renderer, const Map* map);
	void renderGnd(blib::Renderer* renderer, const Map* map);


};