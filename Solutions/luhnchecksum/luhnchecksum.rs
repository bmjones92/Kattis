use std::io;
use std::io::BufRead;

fn main() {
    let num_tests = io::stdin().lock().lines().next().unwrap().unwrap().trim().parse::<u32>().unwrap();

    for _ in 0..num_tests {
        process_test_case();
    }
}

fn process_test_case() {
    // Read the card number `n` for the test case.
    let card_number = io::stdin().lock().lines().next().unwrap().unwrap();
    let card_number = card_number.trim();

    // Get the parity of the string.
    let parity = card_number.len() % 2;

    // Calculate the checksum.
    let checksum: u32 = card_number.chars()
        .map(|value| value as u32 - '0' as u32)
        .enumerate()
        .map(|(idx, value)| if idx % 2 == parity { value * 2 } else { value })
        .map(|value| if value >= 10 { value - 9 } else { value })
        .sum();

    if checksum % 10 == 0 {
        println!("PASS");
    } else {
        println!("FAIL");
    }
}