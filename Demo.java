
import java.util.*;


public class Demo {
  public static void main(String args[]) {
    String data=args.length > 0 ? args[0] : "eggs";
    Map<String, List<String>> dustinsMap = makeMapGramsToFollowList(data, 2);
    System.out.println(dustinsMap);
		System.out.println("There are "  + dustinsMap.size() + " keys:");
		int i=1;
		for (String key: dustinsMap.keySet()) {
						List<String> value = dustinsMap.get(key);
						System.out.format("%d: '%s'='%s'\n", i++, key, value);
		}
  }












  static Map<String, List<String>> makeMapGramsToFollowList(String data, int gramSize) {
    Map<String, List<String>> result = new HashMap<>();
    System.out.println(data);
    // I'm guessing that ngrams should overlap... Should they?
    for (int i=0; i < data.length(); i++) {
      String gram;
      if (i + gramSize < data.length()) {
        gram  = data.substring(i, i+gramSize);
      } else {
        gram = data.substring(i);
      }
      System.out.println("gram='"+gram+"'");
      result.put(gram, new ArrayList<String>());
    }
    for (String gram: result.keySet()) {
      System.out.println("gram='"+gram+"'");
      List<String> followList = result.get(gram);
      int location = data.indexOf(gram);
      while (location != -1) {
        System.out.println("location="+location);
        if (location+gramSize < data.length()) {
          String follow = data.substring(location+gramSize, location+gramSize+1);
          System.out.println("follow:"+follow);
          followList.add(follow);
          location = data.indexOf(gram, location+1);
        } else {
          location = -1;
        }
      }
    }
    return result;
  }
}


