-- Solution to the "Hissing Microphone" problem on Kattis.
-- @author Brendan Jones

solve :: String -> String
solve [] = "no hiss"
solve [x] = "no hiss"
solve (x:y:rest)
    | x == 's' && y == 's' = "hiss"
    | otherwise = solve(y:rest)

main = do
    input <- getLine
    putStrLn (solve input)