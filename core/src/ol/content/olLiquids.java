package ol.content;

import arc.graphics.Color;
import mindustry.content.StatusEffects;
import mindustry.ctype.ContentList;
import mindustry.type.Liquid;

public class olLiquids implements ContentList {
	public static Liquid
		liquidOmalite;

	@Override
	public void load() {
		liquidOmalite = new Liquid("liquid-omalite", Color.valueOf("c0ecff")){{
			viscosity = 0.50f;
			temperature = 0.05f;
			heatCapacity = 1f;
			barColor = Color.valueOf("c0ecff");
			effect = StatusEffects.freezing;
			lightColor = Color.valueOf("c0ecff").a(0.6f);
		}};
	}
}
