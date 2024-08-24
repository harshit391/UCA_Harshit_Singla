class fruitBasket {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();

        int start = 0, maxFruits = 0;

        for (int i = 0; i < fruits.length; i++)
        {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);

            while (start <= i && map.size() > 2)
            {
                map.put(fruits[start], map.get(fruits[start])-1);

                if (map.get(fruits[start]) == 0)
                {
                    map.remove(fruits[start]);
                }

                start++;
            }

            maxFruits = Math.max(maxFruits, i - start + 1);
        }

        return maxFruits;

        
    }
}
