package omaloon.content;

import mindustry.content.*;
import mindustry.game.Objectives.*;

import static arc.struct.Seq.*;
import static mindustry.content.TechTree.*;
import static omaloon.content.OlItems.*;
import static omaloon.content.OlSectorPresets.*;
import static omaloon.content.blocks.OlCraftingBlocks.*;
import static omaloon.content.blocks.OlDefenceBlocks.*;
import static omaloon.content.blocks.OlDistributionBlocks.*;
import static omaloon.content.blocks.OlPowerBlocks.*;
import static omaloon.content.blocks.OlProductionBlocks.*;
import static omaloon.content.blocks.OlStorageBlocks.*;

public class OlTechTree {
	public static void load() {
		OlPlanets.glasmore.techTree = nodeRoot("omaloon", landingCapsule, () -> {
			node(coreFloe);

			node(tubeConveyor, () -> {
				node(tubeDistributor, () -> {
					node(tubeJunction, () -> {
						node(tubeSorter, () -> {
							node(tubeGate);
						});
						node(tubeBridge);
					});
				});
			});

			node(hammerDrill, () -> {
				node(liquidTube, () -> {
					node(liquidJunction, () -> {
						node(liquidBridge);
					});
					node(liquidPump, () -> {
						node(liquidValve);
					});
				});

				node(carborundumPress);

				node(windTurbine, () -> {
					node(smallShelter, () -> {
						node(repairer, with(
							new OnSector(redeploymentPath)
						), () -> {});
					});
					node(impulseNode, () -> {
						node(coalGenerator, with(
							new Produce(Items.coal)
						), () -> {});
					});
				});
			});

			node(apex, with(
				new OnSector(redeploymentPath)
			), () -> {
				node(carborundumWall, () -> node(carborundumWallLarge));
				node(blast, () -> {
					node(convergence, with(
						new OnSector(frozenValley)
					), () -> {});
				});
			});

			// TODO change this when an unit factory is added
//			node(legionnaire, () -> {
//				node(centurion, () -> {
//					node(praetorian);
//				});
//				node(cilantro, () -> {
//					node(basil, () -> {
//						node(sage);
//					});
//					node(effort);
//				});
//				node(lumen, () -> {
//					node(collector);
//				});
//			});

			node(theCrater, () -> {
				node(redeploymentPath, with(
					new SectorComplete(theCrater),
					new Research(coreFloe)
				), () -> {
					node(frozenValley, with(
						new SectorComplete(redeploymentPath),
						new Research(repairer)
					), () -> {

					});
				});
			});

			nodeProduce(cobalt, () -> {
				nodeProduce(Items.beryllium, () -> {
					nodeProduce(carborundum, () -> {});
					nodeProduce(Items.coal, () -> {});
				});
			});
		});
	}
}
