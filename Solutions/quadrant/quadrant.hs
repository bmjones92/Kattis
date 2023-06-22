selectQuad :: [Integer] -> String
selectQuad (x:y:rest) 
    | x > 0 && y > 0 = "1"
    | x < 0 && y > 0 = "2"
    | x < 0 && y < 0 = "3"
    | x > 0 && y < 0 = "4"

readInput :: String -> [Integer]
readInput line = map read (words line)

main = interact(selectQuad . readInput)