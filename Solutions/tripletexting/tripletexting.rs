/**
 * Solution to the "Triple Texting" problem on Kattis.
 * @author Brendan Jones
 */
use std::io;
use std::io::Read;
use std::collections::HashMap;

fn main() {
    // Read input
    let mut input = String::new();
    io::stdin().lock().read_to_string(&mut input).unwrap();

    let word_length = input.len() / 3;

    let mut map: HashMap<&str, i32> = HashMap::new();

    for i in 0..3 {
        let start_index = i * word_length;
        let end_index = start_index + word_length;

        let word = &input[start_index..end_index];
        *map.entry(word).or_insert(1) += 1;
    }

    let word = map.iter()
        .max_by(|a, b| a.1.cmp(&b.1))
        .unwrap();

    println!("{}", word.0);
}
