package logic;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SpockRules {

	private Map<Item, Map<Item, String>> rules = new HashMap<Item, Map<Item, String>>();

	public SpockRules() {
		Map<Item, String> rock = new HashMap<Item, String>();
		rock.put(Item.SCISSORS, "crushes");
		rock.put(Item.LIZARD, "crushes");
		rules.put(Item.ROCK, rock);

		Map<Item, String> spock = new HashMap<Item, String>();
		spock.put(Item.ROCK, "vaporizes");
		spock.put(Item.SCISSORS, "smashes");
		rules.put(Item.SPOCK, spock);

		Map<Item, String> paper = new HashMap<Item, String>();
		paper.put(Item.SPOCK, "disproves");
		paper.put(Item.ROCK, "covers");
		rules.put(Item.PAPER, paper);

		Map<Item, String> scissors = new HashMap<Item, String>();
		scissors.put(Item.PAPER, "cuts");
		scissors.put(Item.LIZARD, "decapitates");
		rules.put(Item.SCISSORS, scissors);

		Map<Item, String> lizard = new HashMap<Item, String>();
		lizard.put(Item.PAPER, "eats");
		lizard.put(Item.SPOCK, "poisons");
		rules.put(Item.LIZARD, lizard);

	}

	public Result getResultOf(Item fig, Item fig2) {
//		for (Entry<Item, Map<Item, String>> entry : getRules().entrySet()) {
//		    System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
//		    
//		}

//		ResultState isWin;
		
		
//		return new Result(fig, fig2, getRules().get(fig).get(fig2), isWin);
		
		
		Map<Item, String> figRules = getRules().get(fig);
	    
	    if (figRules == null || !figRules.containsKey(fig2)) {
	        // Si las reglas no están definidas, o no se encuentra una regla para fig2
	        return new Result(fig, fig2, "No se pudo determinar el resultado", ResultState.UNKNOWN);
	    }
	    
	    String action = figRules.get(fig2);
	    
	    ResultState resultState;
	    
	    if (fig == fig2) {
	        resultState = ResultState.DRAW;
	    } else {
	        switch (action) {
	            case "crushes":
	            case "smashes":
	            case "vaporizes":
	            case "covers":
	            case "cuts":
	                resultState = ResultState.WIN;
	                break;
	            case "decapitates":
	            case "eats":
	            case "poisons":
	            case "disproves":
	                resultState = ResultState.LOSE;
	                break;
	            default:
	                resultState = ResultState.UNKNOWN;
	                break;
	        }
	    }
	    
	    return new Result(fig, fig2, action, resultState);
	}

	public Map<Item, Map<Item, String>> getRules() {

		return Collections.unmodifiableMap(rules);
	}
}
