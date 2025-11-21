package main

func DNAStrand(dna string) string {
	comp_str := ""

	complementary := map[byte]byte{
		65: 84,
		84: 65,
		67: 71,
		71: 67,
	}

	for i := 0; i < len(dna); i++ {
		comp_str += string(complementary[dna[i]])
	}

	return comp_str
}

// 65 - A
// 84 - T
// 71 - G
// 67 - C
