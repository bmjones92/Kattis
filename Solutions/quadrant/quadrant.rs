use std::io;
use std::io::Read;

fn main() {
    let mut input = String::new();
    io::stdin().read_to_string(&mut input).unwrap();

    let input: Vec<i32> = input.split_ascii_whitespace()
        .map(|x| x.parse::<i32>().unwrap())
        .collect();

    let x = input[0];
    let y = input[1];

    let quadrant = match (x.signum(), y.signum()) {
        (1, 1) => 1,
        (-1, 1) => 2,
        (-1, -1) => 3,
        (1, -1) => 4,
        _ => 0,
    };
    println!("{}", quadrant);
}