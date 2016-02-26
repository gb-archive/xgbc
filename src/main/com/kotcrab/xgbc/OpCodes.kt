package com.kotcrab.xgbc

/** @author Kotcrab */

fun generateOpCodes(emu: Emulator, proc: OpCodesProcessor, op: Array<Instr?>) {
    val cpu = emu.cpu;

    op[0x00] = Instr(1, 4, "NOP", {})
    op[0x01] = Instr(3, 12, "LD BC, d16", { proc.ld16ImmValueToReg(Cpu.REG_BC) })
    op[0x02] = Instr(1, 8, "LD (BC), A", { proc.ld8RegToReg16Addr(Cpu.REG_BC, Cpu.REG_A) })
    op[0x03] = Instr(1, 8, "INC BC", { proc.inc16(Cpu.REG_BC) })
    op[0x04] = Instr(1, 4, "INC B", { proc.inc(Cpu.REG_B) })
    op[0x05] = Instr(1, 4, "DEC B", { proc.dec(Cpu.REG_B) })
    op[0x06] = Instr(2, 8, "LD B, d8", { proc.ld8ImmValueToReg(Cpu.REG_B) })
    op[0x07] = Instr(1, 4, "RLCA", {})
    op[0x08] = Instr(3, 20, "LD (a16), SP", { emu.write16(emu.read16(cpu.pc + 1), cpu.sp) })
    op[0x09] = Instr(1, 8, "ADD HL, BC", { proc.addHL(Cpu.REG_BC) })
    op[0x0A] = Instr(1, 8, "LD A, (BC)", { proc.ld8Reg16AddrToReg(Cpu.REG_A, Cpu.REG_BC) })
    op[0x0B] = Instr(1, 8, "DEC BC", { proc.dec16(Cpu.REG_BC) })
    op[0x0C] = Instr(1, 4, "INC C", { proc.inc(Cpu.REG_C) })
    op[0x0D] = Instr(1, 4, "DEC C", { proc.dec(Cpu.REG_C) })
    op[0x0E] = Instr(2, 8, "LD C, d8", { proc.ld8ImmValueToReg(Cpu.REG_C) })
    op[0x0F] = Instr(1, 4, "RRCA", {})
    op[0x10] = Instr(2, 4, "STOP 0", {})
    op[0x11] = Instr(3, 12, "LD DE, d16", { proc.ld16ImmValueToReg(Cpu.REG_DE) })
    op[0x12] = Instr(1, 8, "LD (DE), A", { proc.ld8RegToReg16Addr(Cpu.REG_DE, Cpu.REG_A) })
    op[0x13] = Instr(1, 8, "INC DE", { proc.inc16(Cpu.REG_DE) })
    op[0x14] = Instr(1, 4, "INC D", { proc.inc(Cpu.REG_D) })
    op[0x15] = Instr(1, 4, "DEC D", { proc.dec(Cpu.REG_D) })
    op[0x16] = Instr(2, 8, "LD D, d8", { proc.ld8ImmValueToReg(Cpu.REG_D) })
    op[0x17] = Instr(1, 4, "RLA", {})
    op[0x18] = Instr(2, 12, "JR r8", {})
    op[0x19] = Instr(1, 8, "ADD HL, DE", { proc.addHL(Cpu.REG_DE) })
    op[0x1A] = Instr(1, 8, "LD A, (DE)", { proc.ld8Reg16AddrToReg(Cpu.REG_A, Cpu.REG_DE) })
    op[0x1B] = Instr(1, 8, "DEC DE", { proc.dec16(Cpu.REG_DE) })
    op[0x1C] = Instr(1, 4, "INC E", { proc.inc(Cpu.REG_E) })
    op[0x1D] = Instr(1, 4, "DEC E", { proc.dec(Cpu.REG_E) })
    op[0x1E] = Instr(2, 8, "LD E, d8", { proc.ld8ImmValueToReg(Cpu.REG_E) })
    op[0x1F] = Instr(1, 4, "RRA", {})
    op[0x20] = CondInstr(2, 12, 8, "JR NZ, r8", { false })
    op[0x21] = Instr(3, 12, "LD HL, d16", { proc.ld16ImmValueToReg(Cpu.REG_HL) })
    op[0x22] = Instr(1, 8, "LD (HL+), A", {
        proc.ld8RegToReg16Addr(Cpu.REG_HL, Cpu.REG_A)
        proc.inc16(Cpu.REG_HL)
    })
    op[0x23] = Instr(1, 8, "INC HL", { proc.inc16(Cpu.REG_HL) })
    op[0x24] = Instr(1, 4, "INC H", { proc.inc(Cpu.REG_H) })
    op[0x25] = Instr(1, 4, "DEC H", { proc.dec(Cpu.REG_H) })
    op[0x26] = Instr(2, 8, "LD H, d8", { proc.ld8ImmValueToReg(Cpu.REG_H) })
    op[0x27] = Instr(1, 4, "DAA", {})
    op[0x28] = CondInstr(2, 12, 8, "JR Z, r8", { false })
    op[0x29] = Instr(1, 8, "ADD HL, HL", { proc.addHL(Cpu.REG_HL) })
    op[0x2A] = Instr(1, 8, "LD A, (HL+)", {
        proc.ld8Reg16AddrToReg(Cpu.REG_A, Cpu.REG_HL)
        proc.inc16(Cpu.REG_HL)
    })
    op[0x2B] = Instr(1, 8, "DEC HL", { proc.dec16(Cpu.REG_HL) })
    op[0x2C] = Instr(1, 4, "INC L", { proc.inc(Cpu.REG_L) })
    op[0x2D] = Instr(1, 4, "DEC L", { proc.dec(Cpu.REG_L) })
    op[0x2E] = Instr(2, 8, "LD L, d8", { proc.ld8ImmValueToReg(Cpu.REG_L) })
    op[0x2F] = Instr(1, 4, "CPL", {})
    op[0x30] = CondInstr(2, 12, 8, "JR NC, r8", { false })
    op[0x31] = VoidInstr(3, 12, "LD SP, d16", { cpu.sp = emu.read16(cpu.pc + 1) })
    op[0x32] = Instr(1, 8, "LD (HL-), A", {
        proc.ld8RegToReg16Addr(Cpu.REG_HL, Cpu.REG_A)
        proc.dec16(Cpu.REG_HL)
    })
    op[0x33] = VoidInstr(1, 8, "INC SP", { cpu.sp += 1 })
    op[0x34] = Instr(1, 12, "INC (HL)", { proc.incHL() })
    op[0x35] = Instr(1, 12, "DEC (HL)", { proc.decHL() })
    op[0x36] = VoidInstr(2, 12, "LD (HL), d8", { emu.write(cpu.readReg16(Cpu.REG_HL), emu.read(cpu.pc + 1)) })
    op[0x37] = Instr(1, 4, "SCF", {})
    op[0x38] = CondInstr(2, 12, 8, "JR C, r8", { false })
    op[0x39] = Instr(1, 8, "ADD HL, SP", { proc.addHLSP() })
    op[0x3A] = Instr(1, 8, "LD A, (HL-)", {
        proc.ld8Reg16AddrToReg(Cpu.REG_A, Cpu.REG_HL)
        proc.dec16(Cpu.REG_HL)
    })
    op[0x3B] = VoidInstr(1, 8, "DEC SP", { cpu.sp -= 1 })
    op[0x3C] = Instr(1, 4, "INC A", { proc.inc(Cpu.REG_A) })
    op[0x3D] = Instr(1, 4, "DEC A", { proc.dec(Cpu.REG_A) })
    op[0x3E] = Instr(2, 8, "LD A, d8", { proc.ld8ImmValueToReg(Cpu.REG_A) })
    op[0x3F] = Instr(1, 4, "CCF", {})
    op[0x40] = Instr(1, 4, "LD B, B", { proc.ld8RegToReg(Cpu.REG_B, Cpu.REG_B) })
    op[0x41] = Instr(1, 4, "LD B, C", { proc.ld8RegToReg(Cpu.REG_B, Cpu.REG_C) })
    op[0x42] = Instr(1, 4, "LD B, D", { proc.ld8RegToReg(Cpu.REG_B, Cpu.REG_D) })
    op[0x43] = Instr(1, 4, "LD B, E", { proc.ld8RegToReg(Cpu.REG_B, Cpu.REG_E) })
    op[0x44] = Instr(1, 4, "LD B, H", { proc.ld8RegToReg(Cpu.REG_B, Cpu.REG_H) })
    op[0x45] = Instr(1, 4, "LD B, L", { proc.ld8RegToReg(Cpu.REG_B, Cpu.REG_L) })
    op[0x46] = Instr(1, 8, "LD B, (HL)", { proc.ld8Reg16AddrToReg(Cpu.REG_B, Cpu.REG_HL) })
    op[0x47] = Instr(1, 4, "LD B, A", { proc.ld8RegToReg(Cpu.REG_B, Cpu.REG_A) })
    op[0x48] = Instr(1, 4, "LD C, B", { proc.ld8RegToReg(Cpu.REG_C, Cpu.REG_B) })
    op[0x49] = Instr(1, 4, "LD C, C", { proc.ld8RegToReg(Cpu.REG_C, Cpu.REG_C) })
    op[0x4A] = Instr(1, 4, "LD C, D", { proc.ld8RegToReg(Cpu.REG_C, Cpu.REG_D) })
    op[0x4B] = Instr(1, 4, "LD C, E", { proc.ld8RegToReg(Cpu.REG_C, Cpu.REG_E) })
    op[0x4C] = Instr(1, 4, "LD C, H", { proc.ld8RegToReg(Cpu.REG_C, Cpu.REG_H) })
    op[0x4D] = Instr(1, 4, "LD C, L", { proc.ld8RegToReg(Cpu.REG_C, Cpu.REG_L) })
    op[0x4E] = Instr(1, 8, "LD C, (HL)", { proc.ld8Reg16AddrToReg(Cpu.REG_C, Cpu.REG_HL) })
    op[0x4F] = Instr(1, 4, "LD C, A", { proc.ld8RegToReg(Cpu.REG_C, Cpu.REG_A) })
    op[0x50] = Instr(1, 4, "LD D, B", { proc.ld8RegToReg(Cpu.REG_D, Cpu.REG_B) })
    op[0x51] = Instr(1, 4, "LD D, C", { proc.ld8RegToReg(Cpu.REG_D, Cpu.REG_C) })
    op[0x52] = Instr(1, 4, "LD D, D", { proc.ld8RegToReg(Cpu.REG_D, Cpu.REG_D) })
    op[0x53] = Instr(1, 4, "LD D, E", { proc.ld8RegToReg(Cpu.REG_D, Cpu.REG_E) })
    op[0x54] = Instr(1, 4, "LD D, H", { proc.ld8RegToReg(Cpu.REG_D, Cpu.REG_H) })
    op[0x55] = Instr(1, 4, "LD D, L", { proc.ld8RegToReg(Cpu.REG_D, Cpu.REG_L) })
    op[0x56] = Instr(1, 8, "LD D, (HL)", { proc.ld8Reg16AddrToReg(Cpu.REG_D, Cpu.REG_HL) })
    op[0x57] = Instr(1, 4, "LD D, A", { proc.ld8RegToReg(Cpu.REG_D, Cpu.REG_A) })
    op[0x58] = Instr(1, 4, "LD E, B", { proc.ld8RegToReg(Cpu.REG_E, Cpu.REG_B) })
    op[0x59] = Instr(1, 4, "LD E, C", { proc.ld8RegToReg(Cpu.REG_E, Cpu.REG_C) })
    op[0x5A] = Instr(1, 4, "LD E, D", { proc.ld8RegToReg(Cpu.REG_E, Cpu.REG_D) })
    op[0x5B] = Instr(1, 4, "LD E, E", { proc.ld8RegToReg(Cpu.REG_E, Cpu.REG_E) })
    op[0x5C] = Instr(1, 4, "LD E, H", { proc.ld8RegToReg(Cpu.REG_E, Cpu.REG_H) })
    op[0x5D] = Instr(1, 4, "LD E, L", { proc.ld8RegToReg(Cpu.REG_E, Cpu.REG_L) })
    op[0x5E] = Instr(1, 8, "LD E, (HL)", { proc.ld8Reg16AddrToReg(Cpu.REG_E, Cpu.REG_HL) })
    op[0x5F] = Instr(1, 4, "LD E, A", { proc.ld8RegToReg(Cpu.REG_E, Cpu.REG_A) })
    op[0x60] = Instr(1, 4, "LD H, B", { proc.ld8RegToReg(Cpu.REG_H, Cpu.REG_B) })
    op[0x61] = Instr(1, 4, "LD H, C", { proc.ld8RegToReg(Cpu.REG_H, Cpu.REG_C) })
    op[0x62] = Instr(1, 4, "LD H, D", { proc.ld8RegToReg(Cpu.REG_H, Cpu.REG_D) })
    op[0x63] = Instr(1, 4, "LD H, E", { proc.ld8RegToReg(Cpu.REG_H, Cpu.REG_E) })
    op[0x64] = Instr(1, 4, "LD H, H", { proc.ld8RegToReg(Cpu.REG_H, Cpu.REG_H) })
    op[0x65] = Instr(1, 4, "LD H, L", { proc.ld8RegToReg(Cpu.REG_H, Cpu.REG_L) })
    op[0x66] = Instr(1, 8, "LD H, (HL)", { proc.ld8Reg16AddrToReg(Cpu.REG_H, Cpu.REG_HL) })
    op[0x67] = Instr(1, 4, "LD H, A", { proc.ld8RegToReg(Cpu.REG_H, Cpu.REG_A) })
    op[0x68] = Instr(1, 4, "LD L, B", { proc.ld8RegToReg(Cpu.REG_L, Cpu.REG_B) })
    op[0x69] = Instr(1, 4, "LD L, C", { proc.ld8RegToReg(Cpu.REG_L, Cpu.REG_C) })
    op[0x6A] = Instr(1, 4, "LD L, D", { proc.ld8RegToReg(Cpu.REG_L, Cpu.REG_D) })
    op[0x6B] = Instr(1, 4, "LD L, E", { proc.ld8RegToReg(Cpu.REG_L, Cpu.REG_E) })
    op[0x6C] = Instr(1, 4, "LD L, H", { proc.ld8RegToReg(Cpu.REG_L, Cpu.REG_H) })
    op[0x6D] = Instr(1, 4, "LD L, L", { proc.ld8RegToReg(Cpu.REG_L, Cpu.REG_L) })
    op[0x6E] = Instr(1, 8, "LD L, (HL)", { proc.ld8Reg16AddrToReg(Cpu.REG_L, Cpu.REG_HL) })
    op[0x6F] = Instr(1, 4, "LD L, A", { proc.ld8RegToReg(Cpu.REG_L, Cpu.REG_A) })
    op[0x70] = Instr(1, 8, "LD (HL), B", { proc.ld8RegToReg16Addr(Cpu.REG_HL, Cpu.REG_B) })
    op[0x71] = Instr(1, 8, "LD (HL), C", { proc.ld8RegToReg16Addr(Cpu.REG_HL, Cpu.REG_C) })
    op[0x72] = Instr(1, 8, "LD (HL), D", { proc.ld8RegToReg16Addr(Cpu.REG_HL, Cpu.REG_D) })
    op[0x73] = Instr(1, 8, "LD (HL), E", { proc.ld8RegToReg16Addr(Cpu.REG_HL, Cpu.REG_E) })
    op[0x74] = Instr(1, 8, "LD (HL), H", { proc.ld8RegToReg16Addr(Cpu.REG_HL, Cpu.REG_H) })
    op[0x75] = Instr(1, 8, "LD (HL), L", { proc.ld8RegToReg16Addr(Cpu.REG_HL, Cpu.REG_L) })
    op[0x76] = Instr(1, 4, "HALT", {})
    op[0x77] = Instr(1, 8, "LD (HL), A", { proc.ld8RegToReg16Addr(Cpu.REG_HL, Cpu.REG_A) })
    op[0x78] = Instr(1, 4, "LD A, B", { proc.ld8RegToReg(Cpu.REG_A, Cpu.REG_B) })
    op[0x79] = Instr(1, 4, "LD A, C", { proc.ld8RegToReg(Cpu.REG_A, Cpu.REG_C) })
    op[0x7A] = Instr(1, 4, "LD A, D", { proc.ld8RegToReg(Cpu.REG_A, Cpu.REG_D) })
    op[0x7B] = Instr(1, 4, "LD A, E", { proc.ld8RegToReg(Cpu.REG_A, Cpu.REG_E) })
    op[0x7C] = Instr(1, 4, "LD A, H", { proc.ld8RegToReg(Cpu.REG_A, Cpu.REG_H) })
    op[0x7D] = Instr(1, 4, "LD A, L", { proc.ld8RegToReg(Cpu.REG_A, Cpu.REG_L) })
    op[0x7E] = Instr(1, 8, "LD A, (HL)", { proc.ld8Reg16AddrToReg(Cpu.REG_A, Cpu.REG_HL) })
    op[0x7F] = Instr(1, 4, "LD A, A", { proc.ld8RegToReg(Cpu.REG_A, Cpu.REG_A) })
    op[0x80] = Instr(1, 4, "ADD A, B", { proc.addReg(Cpu.REG_B) })
    op[0x81] = Instr(1, 4, "ADD A, C", { proc.addReg(Cpu.REG_C) })
    op[0x82] = Instr(1, 4, "ADD A, D", { proc.addReg(Cpu.REG_D) })
    op[0x83] = Instr(1, 4, "ADD A, E", { proc.addReg(Cpu.REG_E) })
    op[0x84] = Instr(1, 4, "ADD A, H", { proc.addReg(Cpu.REG_H) })
    op[0x85] = Instr(1, 4, "ADD A, L", { proc.addReg(Cpu.REG_L) })
    op[0x86] = Instr(1, 8, "ADD A, (HL)", { proc.add(emu.readInt(cpu.readReg16(Cpu.REG_HL))) })
    op[0x87] = Instr(1, 4, "ADD A, A", { proc.addReg(Cpu.REG_A) })
    op[0x88] = Instr(1, 4, "ADC A, B", { proc.adcReg(Cpu.REG_B) })
    op[0x89] = Instr(1, 4, "ADC A, C", { proc.adcReg(Cpu.REG_C) })
    op[0x8A] = Instr(1, 4, "ADC A, D", { proc.adcReg(Cpu.REG_D) })
    op[0x8B] = Instr(1, 4, "ADC A, E", { proc.adcReg(Cpu.REG_E) })
    op[0x8C] = Instr(1, 4, "ADC A, H", { proc.adcReg(Cpu.REG_H) })
    op[0x8D] = Instr(1, 4, "ADC A, L", { proc.adcReg(Cpu.REG_L) })
    op[0x8E] = Instr(1, 8, "ADC A, (HL)", { proc.adc(emu.readInt(cpu.readReg16(Cpu.REG_HL))) })
    op[0x8F] = Instr(1, 4, "ADC A, A", { proc.adcReg(Cpu.REG_A) })
    op[0x90] = Instr(1, 4, "SUB B", { proc.subReg(Cpu.REG_B) })
    op[0x91] = Instr(1, 4, "SUB C", { proc.subReg(Cpu.REG_C) })
    op[0x92] = Instr(1, 4, "SUB D", { proc.subReg(Cpu.REG_D) })
    op[0x93] = Instr(1, 4, "SUB E", { proc.subReg(Cpu.REG_E) })
    op[0x94] = Instr(1, 4, "SUB H", { proc.subReg(Cpu.REG_H) })
    op[0x95] = Instr(1, 4, "SUB L", { proc.subReg(Cpu.REG_L) })
    op[0x96] = Instr(1, 8, "SUB (HL)", { proc.sub(emu.readInt(cpu.readReg16(Cpu.REG_HL))) })
    op[0x97] = Instr(1, 4, "SUB A", { proc.subReg(Cpu.REG_A) })
    op[0x98] = Instr(1, 4, "SBC A, B", { proc.sbcReg(Cpu.REG_B) })
    op[0x99] = Instr(1, 4, "SBC A, C", { proc.sbcReg(Cpu.REG_C) })
    op[0x9A] = Instr(1, 4, "SBC A, D", { proc.sbcReg(Cpu.REG_D) })
    op[0x9B] = Instr(1, 4, "SBC A, E", { proc.sbcReg(Cpu.REG_E) })
    op[0x9C] = Instr(1, 4, "SBC A, H", { proc.sbcReg(Cpu.REG_H) })
    op[0x9D] = Instr(1, 4, "SBC A, L", { proc.sbcReg(Cpu.REG_L) })
    op[0x9E] = Instr(1, 8, "SBC A, (HL)", { proc.sbc(emu.readInt(cpu.readReg16(Cpu.REG_HL))) })
    op[0x9F] = Instr(1, 4, "SBC A, A", { proc.sbcReg(Cpu.REG_A) })
    op[0xA0] = Instr(1, 4, "AND B", { proc.andReg(Cpu.REG_B) })
    op[0xA1] = Instr(1, 4, "AND C", { proc.andReg(Cpu.REG_C) })
    op[0xA2] = Instr(1, 4, "AND D", { proc.andReg(Cpu.REG_D) })
    op[0xA3] = Instr(1, 4, "AND E", { proc.andReg(Cpu.REG_E) })
    op[0xA4] = Instr(1, 4, "AND H", { proc.andReg(Cpu.REG_H) })
    op[0xA5] = Instr(1, 4, "AND L", { proc.andReg(Cpu.REG_L) })
    op[0xA6] = Instr(1, 8, "AND (HL)", { proc.and(emu.readInt(cpu.readReg16(Cpu.REG_HL))) })
    op[0xA7] = Instr(1, 4, "AND A", { proc.andReg(Cpu.REG_A) })
    op[0xA8] = Instr(1, 4, "XOR B", { proc.xorReg(Cpu.REG_B) })
    op[0xA9] = Instr(1, 4, "XOR C", { proc.xorReg(Cpu.REG_C) })
    op[0xAA] = Instr(1, 4, "XOR D", { proc.xorReg(Cpu.REG_D) })
    op[0xAB] = Instr(1, 4, "XOR E", { proc.xorReg(Cpu.REG_E) })
    op[0xAC] = Instr(1, 4, "XOR H", { proc.xorReg(Cpu.REG_H) })
    op[0xAD] = Instr(1, 4, "XOR L", { proc.xorReg(Cpu.REG_L) })
    op[0xAE] = Instr(1, 8, "XOR (HL)", { proc.xor(emu.readInt(cpu.readReg16(Cpu.REG_HL))) })
    op[0xAF] = Instr(1, 4, "XOR A", { proc.xorReg(Cpu.REG_A) })
    op[0xB0] = Instr(1, 4, "OR B", { proc.orReg(Cpu.REG_B) })
    op[0xB1] = Instr(1, 4, "OR C", { proc.orReg(Cpu.REG_C) })
    op[0xB2] = Instr(1, 4, "OR D", { proc.orReg(Cpu.REG_D) })
    op[0xB3] = Instr(1, 4, "OR E", { proc.orReg(Cpu.REG_E) })
    op[0xB4] = Instr(1, 4, "OR H", { proc.orReg(Cpu.REG_H) })
    op[0xB5] = Instr(1, 4, "OR L", { proc.orReg(Cpu.REG_L) })
    op[0xB6] = Instr(1, 8, "OR (HL)", { proc.or(emu.readInt(cpu.readReg16(Cpu.REG_HL))) })
    op[0xB7] = Instr(1, 4, "OR A", { proc.orReg(Cpu.REG_A) })
    op[0xB8] = Instr(1, 4, "CP B", { proc.cpReg(Cpu.REG_B) })
    op[0xB9] = Instr(1, 4, "CP C", { proc.cpReg(Cpu.REG_C) })
    op[0xBA] = Instr(1, 4, "CP D", { proc.cpReg(Cpu.REG_D) })
    op[0xBB] = Instr(1, 4, "CP E", { proc.cpReg(Cpu.REG_E) })
    op[0xBC] = Instr(1, 4, "CP H", { proc.cpReg(Cpu.REG_H) })
    op[0xBD] = Instr(1, 4, "CP L", { proc.cpReg(Cpu.REG_L) })
    op[0xBE] = Instr(1, 8, "CP (HL)", { proc.cp(emu.readInt(cpu.readReg16(Cpu.REG_HL))) })
    op[0xBF] = Instr(1, 4, "CP A", { proc.cpReg(Cpu.REG_A) })
    op[0xC0] = CondInstr(1, 20, 8, "RET NZ", { false })
    op[0xC1] = Instr(1, 12, "POP BC", { proc.pop(Cpu.REG_BC) })
    op[0xC2] = CondInstr(3, 16, 12, "JP NZ, a16", { false })
    op[0xC3] = Instr(3, 16, "JP a16", {})
    op[0xC4] = CondInstr(3, 24, 12, "CALL NZ, a16", { false })
    op[0xC5] = Instr(1, 16, "PUSH BC", { proc.push(Cpu.REG_BC) })
    op[0xC6] = Instr(2, 8, "ADD A, d8", { proc.add(emu.readInt(cpu.pc + 1)) })
    op[0xC7] = Instr(1, 16, "RST 00H", {})
    op[0xC8] = CondInstr(1, 20, 8, "RET Z", { false })
    op[0xC9] = Instr(1, 16, "RET", {})
    op[0xCA] = CondInstr(3, 16, 12, "JP Z, a16", { false })
    op[0xCB] = Instr(1, 4, "PREFIX CB", {})
    op[0xCC] = CondInstr(3, 24, 12, "CALL Z, a16", { false })
    op[0xCD] = Instr(3, 24, "CALL a16", {})
    op[0xCE] = Instr(2, 8, "ADC A, d8", { proc.adc(emu.readInt(cpu.pc + 1)) })
    op[0xCF] = Instr(1, 16, "RST 08H", {})
    op[0xD0] = CondInstr(1, 20, 8, "RET NC", { false })
    op[0xD1] = Instr(1, 12, "POP DE", { proc.pop(Cpu.REG_DE) })
    op[0xD2] = CondInstr(3, 16, 12, "JP NC, a16", { false })
    op[0xD3] = null
    op[0xD4] = CondInstr(3, 24, 12, "CALL NC, a16", { false })
    op[0xD5] = Instr(1, 16, "PUSH DE", { proc.push(Cpu.REG_DE) })
    op[0xD6] = Instr(2, 8, "SUB d8", { proc.sub(emu.readInt(cpu.pc + 1)) })
    op[0xD7] = Instr(1, 16, "RST 10H", {})
    op[0xD8] = CondInstr(1, 20, 8, "RET C", { false })
    op[0xD9] = Instr(1, 16, "RETI", {})
    op[0xDA] = CondInstr(3, 16, 12, "JP C, a16", { false })
    op[0xDB] = null
    op[0xDC] = CondInstr(3, 24, 12, "CALL C, a16", { false })
    op[0xDD] = null
    op[0xDE] = Instr(2, 8, "SBC A, d8", { proc.sbc(emu.readInt(cpu.pc + 1)) })
    op[0xDF] = Instr(1, 16, "RST 18H", {})
    op[0xE0] = Instr(2, 12, "LDH (a8), A", { proc.ld8RegToAddr(0xFF00 + emu.read(cpu.pc + 1), Cpu.REG_A) })
    op[0xE1] = Instr(1, 12, "POP HL", { proc.pop(Cpu.REG_HL) })
    op[0xE2] = Instr(2, 8, "LD (C), A", { proc.ld8RegToAddr(0xFF00 + cpu.readReg(Cpu.REG_C), Cpu.REG_A) })
    op[0xE3] = null
    op[0xE4] = null
    op[0xE5] = Instr(1, 16, "PUSH HL", { proc.push(Cpu.REG_HL) })
    op[0xE6] = Instr(2, 8, "AND d8", { proc.and(emu.readInt(cpu.pc + 1)) })
    op[0xE7] = Instr(1, 16, "RST 20H", {})
    op[0xE8] = VoidInstr(2, 16, "ADD SP, r8", {
        cpu.resetFlag(Cpu.FLAG_Z)
        cpu.resetFlag(Cpu.FLAG_N)

        val value = emu.readInt(cpu.pc + 1);

        if ((cpu.sp and 0xFFF) + (value and 0xFFF) and 0x1000 != 0) cpu.setFlag(Cpu.FLAG_H) else cpu.resetFlag(Cpu.FLAG_H)
        if ((cpu.sp and 0xFFFF) + (value and 0xFFFF) and 0x10000 != 0) cpu.setFlag(Cpu.FLAG_C) else cpu.resetFlag(Cpu.FLAG_C)

        cpu.sp = cpu.sp + value
    })
    op[0xE9] = Instr(1, 4, "JP (HL)", {})
    op[0xEA] = Instr(3, 16, "LD (a16), A", { proc.ld8RegToImmAddr(Cpu.REG_A) })
    op[0xEB] = null
    op[0xEC] = null
    op[0xED] = null
    op[0xEE] = Instr(2, 8, "XOR d8", { proc.xor(emu.readInt(cpu.pc + 1)) })
    op[0xEF] = Instr(1, 16, "RST 28H", {})
    op[0xF0] = Instr(2, 12, "LDH A, (a8)", { proc.ld8AddrToReg(Cpu.REG_A, 0xFF00 + emu.read(cpu.pc + 1)) })
    op[0xF1] = Instr(1, 12, "POP AF", { proc.pop(Cpu.REG_AF) })
    op[0xF2] = Instr(2, 8, "LD A, (C)", { proc.ld8AddrToReg(Cpu.REG_A, 0xFF00 + cpu.readReg(Cpu.REG_C)) })
    op[0xF3] = Instr(1, 4, "DI", {})
    op[0xF4] = null
    op[0xF5] = Instr(1, 16, "PUSH AF", { proc.push(Cpu.REG_AF) })
    op[0xF6] = Instr(2, 8, "OR d8", { proc.or(emu.readInt(cpu.pc + 1)) })
    op[0xF7] = Instr(1, 16, "RST 30H", {})
    op[0xF8] = VoidInstr(2, 12, "LD HL, SP+r8", {
        cpu.resetFlag(Cpu.FLAG_Z)
        cpu.resetFlag(Cpu.FLAG_N)

        val value = emu.readInt(cpu.pc + 1);

        if ((cpu.sp and 0xFFF) + (value and 0xFFF) and 0x1000 != 0) cpu.setFlag(Cpu.FLAG_H) else cpu.resetFlag(Cpu.FLAG_H)
        if ((cpu.sp and 0xFFFF) + (value and 0xFFFF) and 0x10000 != 0) cpu.setFlag(Cpu.FLAG_C) else cpu.resetFlag(Cpu.FLAG_C)

        cpu.writeReg16(Cpu.REG_HL, cpu.sp + value)
    })
    op[0xF9] = VoidInstr(1, 8, "LD SP, HL", { cpu.sp = cpu.readReg16(Cpu.REG_HL) })
    op[0xFA] = Instr(3, 16, "LD A, (a16)", { proc.ld8ImmAddrToReg(Cpu.REG_A) })
    op[0xFB] = Instr(1, 4, "EI", {})
    op[0xFC] = null
    op[0xFD] = null
    op[0xFE] = Instr(2, 8, "CP d8", {})
    op[0xFF] = Instr(1, 16, "RST 38H", {})
}

fun generateExtOpCodes(opProc: OpCodesProcessor, op: Array<Instr?>) {
    op[0x00] = Instr(2, 8, "RLC B", {})
    op[0x01] = Instr(2, 8, "RLC C", {})
    op[0x02] = Instr(2, 8, "RLC D", {})
    op[0x03] = Instr(2, 8, "RLC E", {})
    op[0x04] = Instr(2, 8, "RLC H", {})
    op[0x05] = Instr(2, 8, "RLC L", {})
    op[0x06] = Instr(2, 16, "RLC (HL)", {})
    op[0x07] = Instr(2, 8, "RLC A", {})
    op[0x08] = Instr(2, 8, "RRC B", {})
    op[0x09] = Instr(2, 8, "RRC C", {})
    op[0x0A] = Instr(2, 8, "RRC D", {})
    op[0x0B] = Instr(2, 8, "RRC E", {})
    op[0x0C] = Instr(2, 8, "RRC H", {})
    op[0x0D] = Instr(2, 8, "RRC L", {})
    op[0x0E] = Instr(2, 16, "RRC (HL)", {})
    op[0x0F] = Instr(2, 8, "RRC A", {})
    op[0x10] = Instr(2, 8, "RL B", {})
    op[0x11] = Instr(2, 8, "RL C", {})
    op[0x12] = Instr(2, 8, "RL D", {})
    op[0x13] = Instr(2, 8, "RL E", {})
    op[0x14] = Instr(2, 8, "RL H", {})
    op[0x15] = Instr(2, 8, "RL L", {})
    op[0x16] = Instr(2, 16, "RL (HL)", {})
    op[0x17] = Instr(2, 8, "RL A", {})
    op[0x18] = Instr(2, 8, "RR B", {})
    op[0x19] = Instr(2, 8, "RR C", {})
    op[0x1A] = Instr(2, 8, "RR D", {})
    op[0x1B] = Instr(2, 8, "RR E", {})
    op[0x1C] = Instr(2, 8, "RR H", {})
    op[0x1D] = Instr(2, 8, "RR L", {})
    op[0x1E] = Instr(2, 16, "RR (HL)", {})
    op[0x1F] = Instr(2, 8, "RR A", {})
    op[0x20] = Instr(2, 8, "SLA B", {})
    op[0x21] = Instr(2, 8, "SLA C", {})
    op[0x22] = Instr(2, 8, "SLA D", {})
    op[0x23] = Instr(2, 8, "SLA E", {})
    op[0x24] = Instr(2, 8, "SLA H", {})
    op[0x25] = Instr(2, 8, "SLA L", {})
    op[0x26] = Instr(2, 16, "SLA (HL)", {})
    op[0x27] = Instr(2, 8, "SLA A", {})
    op[0x28] = Instr(2, 8, "SRA B", {})
    op[0x29] = Instr(2, 8, "SRA C", {})
    op[0x2A] = Instr(2, 8, "SRA D", {})
    op[0x2B] = Instr(2, 8, "SRA E", {})
    op[0x2C] = Instr(2, 8, "SRA H", {})
    op[0x2D] = Instr(2, 8, "SRA L", {})
    op[0x2E] = Instr(2, 16, "SRA (HL)", {})
    op[0x2F] = Instr(2, 8, "SRA A", {})
    op[0x30] = Instr(2, 8, "SWAP B", {})
    op[0x31] = Instr(2, 8, "SWAP C", {})
    op[0x32] = Instr(2, 8, "SWAP D", {})
    op[0x33] = Instr(2, 8, "SWAP E", {})
    op[0x34] = Instr(2, 8, "SWAP H", {})
    op[0x35] = Instr(2, 8, "SWAP L", {})
    op[0x36] = Instr(2, 16, "SWAP (HL)", {})
    op[0x37] = Instr(2, 8, "SWAP A", {})
    op[0x38] = Instr(2, 8, "SRL B", {})
    op[0x39] = Instr(2, 8, "SRL C", {})
    op[0x3A] = Instr(2, 8, "SRL D", {})
    op[0x3B] = Instr(2, 8, "SRL E", {})
    op[0x3C] = Instr(2, 8, "SRL H", {})
    op[0x3D] = Instr(2, 8, "SRL L", {})
    op[0x3E] = Instr(2, 16, "SRL (HL)", {})
    op[0x3F] = Instr(2, 8, "SRL A", {})
    op[0x40] = Instr(2, 8, "BIT 0, B", {})
    op[0x41] = Instr(2, 8, "BIT 0, C", {})
    op[0x42] = Instr(2, 8, "BIT 0, D", {})
    op[0x43] = Instr(2, 8, "BIT 0, E", {})
    op[0x44] = Instr(2, 8, "BIT 0, H", {})
    op[0x45] = Instr(2, 8, "BIT 0, L", {})
    op[0x46] = Instr(2, 16, "BIT 0, (HL)", {})
    op[0x47] = Instr(2, 8, "BIT 0, A", {})
    op[0x48] = Instr(2, 8, "BIT 1, B", {})
    op[0x49] = Instr(2, 8, "BIT 1, C", {})
    op[0x4A] = Instr(2, 8, "BIT 1, D", {})
    op[0x4B] = Instr(2, 8, "BIT 1, E", {})
    op[0x4C] = Instr(2, 8, "BIT 1, H", {})
    op[0x4D] = Instr(2, 8, "BIT 1, L", {})
    op[0x4E] = Instr(2, 16, "BIT 1, (HL)", {})
    op[0x4F] = Instr(2, 8, "BIT 1, A", {})
    op[0x50] = Instr(2, 8, "BIT 2, B", {})
    op[0x51] = Instr(2, 8, "BIT 2, C", {})
    op[0x52] = Instr(2, 8, "BIT 2, D", {})
    op[0x53] = Instr(2, 8, "BIT 2, E", {})
    op[0x54] = Instr(2, 8, "BIT 2, H", {})
    op[0x55] = Instr(2, 8, "BIT 2, L", {})
    op[0x56] = Instr(2, 16, "BIT 2, (HL)", {})
    op[0x57] = Instr(2, 8, "BIT 2, A", {})
    op[0x58] = Instr(2, 8, "BIT 3, B", {})
    op[0x59] = Instr(2, 8, "BIT 3, C", {})
    op[0x5A] = Instr(2, 8, "BIT 3, D", {})
    op[0x5B] = Instr(2, 8, "BIT 3, E", {})
    op[0x5C] = Instr(2, 8, "BIT 3, H", {})
    op[0x5D] = Instr(2, 8, "BIT 3, L", {})
    op[0x5E] = Instr(2, 16, "BIT 3, (HL)", {})
    op[0x5F] = Instr(2, 8, "BIT 3, A", {})
    op[0x60] = Instr(2, 8, "BIT 4, B", {})
    op[0x61] = Instr(2, 8, "BIT 4, C", {})
    op[0x62] = Instr(2, 8, "BIT 4, D", {})
    op[0x63] = Instr(2, 8, "BIT 4, E", {})
    op[0x64] = Instr(2, 8, "BIT 4, H", {})
    op[0x65] = Instr(2, 8, "BIT 4, L", {})
    op[0x66] = Instr(2, 16, "BIT 4, (HL)", {})
    op[0x67] = Instr(2, 8, "BIT 4, A", {})
    op[0x68] = Instr(2, 8, "BIT 5, B", {})
    op[0x69] = Instr(2, 8, "BIT 5, C", {})
    op[0x6A] = Instr(2, 8, "BIT 5, D", {})
    op[0x6B] = Instr(2, 8, "BIT 5, E", {})
    op[0x6C] = Instr(2, 8, "BIT 5, H", {})
    op[0x6D] = Instr(2, 8, "BIT 5, L", {})
    op[0x6E] = Instr(2, 16, "BIT 5, (HL)", {})
    op[0x6F] = Instr(2, 8, "BIT 5, A", {})
    op[0x70] = Instr(2, 8, "BIT 6, B", {})
    op[0x71] = Instr(2, 8, "BIT 6, C", {})
    op[0x72] = Instr(2, 8, "BIT 6, D", {})
    op[0x73] = Instr(2, 8, "BIT 6, E", {})
    op[0x74] = Instr(2, 8, "BIT 6, H", {})
    op[0x75] = Instr(2, 8, "BIT 6, L", {})
    op[0x76] = Instr(2, 16, "BIT 6, (HL)", {})
    op[0x77] = Instr(2, 8, "BIT 6, A", {})
    op[0x78] = Instr(2, 8, "BIT 7, B", {})
    op[0x79] = Instr(2, 8, "BIT 7, C", {})
    op[0x7A] = Instr(2, 8, "BIT 7, D", {})
    op[0x7B] = Instr(2, 8, "BIT 7, E", {})
    op[0x7C] = Instr(2, 8, "BIT 7, H", {})
    op[0x7D] = Instr(2, 8, "BIT 7, L", {})
    op[0x7E] = Instr(2, 16, "BIT 7, (HL)", {})
    op[0x7F] = Instr(2, 8, "BIT 7, A", {})
    op[0x80] = Instr(2, 8, "RES 0, B", {})
    op[0x81] = Instr(2, 8, "RES 0, C", {})
    op[0x82] = Instr(2, 8, "RES 0, D", {})
    op[0x83] = Instr(2, 8, "RES 0, E", {})
    op[0x84] = Instr(2, 8, "RES 0, H", {})
    op[0x85] = Instr(2, 8, "RES 0, L", {})
    op[0x86] = Instr(2, 16, "RES 0, (HL)", {})
    op[0x87] = Instr(2, 8, "RES 0, A", {})
    op[0x88] = Instr(2, 8, "RES 1, B", {})
    op[0x89] = Instr(2, 8, "RES 1, C", {})
    op[0x8A] = Instr(2, 8, "RES 1, D", {})
    op[0x8B] = Instr(2, 8, "RES 1, E", {})
    op[0x8C] = Instr(2, 8, "RES 1, H", {})
    op[0x8D] = Instr(2, 8, "RES 1, L", {})
    op[0x8E] = Instr(2, 16, "RES 1, (HL)", {})
    op[0x8F] = Instr(2, 8, "RES 1, A", {})
    op[0x90] = Instr(2, 8, "RES 2, B", {})
    op[0x91] = Instr(2, 8, "RES 2, C", {})
    op[0x92] = Instr(2, 8, "RES 2, D", {})
    op[0x93] = Instr(2, 8, "RES 2, E", {})
    op[0x94] = Instr(2, 8, "RES 2, H", {})
    op[0x95] = Instr(2, 8, "RES 2, L", {})
    op[0x96] = Instr(2, 16, "RES 2, (HL)", {})
    op[0x97] = Instr(2, 8, "RES 2, A", {})
    op[0x98] = Instr(2, 8, "RES 3, B", {})
    op[0x99] = Instr(2, 8, "RES 3, C", {})
    op[0x9A] = Instr(2, 8, "RES 3, D", {})
    op[0x9B] = Instr(2, 8, "RES 3, E", {})
    op[0x9C] = Instr(2, 8, "RES 3, H", {})
    op[0x9D] = Instr(2, 8, "RES 3, L", {})
    op[0x9E] = Instr(2, 16, "RES 3, (HL)", {})
    op[0x9F] = Instr(2, 8, "RES 3, A", {})
    op[0xA0] = Instr(2, 8, "RES 4, B", {})
    op[0xA1] = Instr(2, 8, "RES 4, C", {})
    op[0xA2] = Instr(2, 8, "RES 4, D", {})
    op[0xA3] = Instr(2, 8, "RES 4, E", {})
    op[0xA4] = Instr(2, 8, "RES 4, H", {})
    op[0xA5] = Instr(2, 8, "RES 4, L", {})
    op[0xA6] = Instr(2, 16, "RES 4, (HL)", {})
    op[0xA7] = Instr(2, 8, "RES 4, A", {})
    op[0xA8] = Instr(2, 8, "RES 5, B", {})
    op[0xA9] = Instr(2, 8, "RES 5, C", {})
    op[0xAA] = Instr(2, 8, "RES 5, D", {})
    op[0xAB] = Instr(2, 8, "RES 5, E", {})
    op[0xAC] = Instr(2, 8, "RES 5, H", {})
    op[0xAD] = Instr(2, 8, "RES 5, L", {})
    op[0xAE] = Instr(2, 16, "RES 5, (HL)", {})
    op[0xAF] = Instr(2, 8, "RES 5, A", {})
    op[0xB0] = Instr(2, 8, "RES 6, B", {})
    op[0xB1] = Instr(2, 8, "RES 6, C", {})
    op[0xB2] = Instr(2, 8, "RES 6, D", {})
    op[0xB3] = Instr(2, 8, "RES 6, E", {})
    op[0xB4] = Instr(2, 8, "RES 6, H", {})
    op[0xB5] = Instr(2, 8, "RES 6, L", {})
    op[0xB6] = Instr(2, 16, "RES 6, (HL)", {})
    op[0xB7] = Instr(2, 8, "RES 6, A", {})
    op[0xB8] = Instr(2, 8, "RES 7, B", {})
    op[0xB9] = Instr(2, 8, "RES 7, C", {})
    op[0xBA] = Instr(2, 8, "RES 7, D", {})
    op[0xBB] = Instr(2, 8, "RES 7, E", {})
    op[0xBC] = Instr(2, 8, "RES 7, H", {})
    op[0xBD] = Instr(2, 8, "RES 7, L", {})
    op[0xBE] = Instr(2, 16, "RES 7, (HL)", {})
    op[0xBF] = Instr(2, 8, "RES 7, A", {})
    op[0xC0] = Instr(2, 8, "SET 0, B", {})
    op[0xC1] = Instr(2, 8, "SET 0, C", {})
    op[0xC2] = Instr(2, 8, "SET 0, D", {})
    op[0xC3] = Instr(2, 8, "SET 0, E", {})
    op[0xC4] = Instr(2, 8, "SET 0, H", {})
    op[0xC5] = Instr(2, 8, "SET 0, L", {})
    op[0xC6] = Instr(2, 16, "SET 0, (HL)", {})
    op[0xC7] = Instr(2, 8, "SET 0, A", {})
    op[0xC8] = Instr(2, 8, "SET 1, B", {})
    op[0xC9] = Instr(2, 8, "SET 1, C", {})
    op[0xCA] = Instr(2, 8, "SET 1, D", {})
    op[0xCB] = Instr(2, 8, "SET 1, E", {})
    op[0xCC] = Instr(2, 8, "SET 1, H", {})
    op[0xCD] = Instr(2, 8, "SET 1, L", {})
    op[0xCE] = Instr(2, 16, "SET 1, (HL)", {})
    op[0xCF] = Instr(2, 8, "SET 1, A", {})
    op[0xD0] = Instr(2, 8, "SET 2, B", {})
    op[0xD1] = Instr(2, 8, "SET 2, C", {})
    op[0xD2] = Instr(2, 8, "SET 2, D", {})
    op[0xD3] = Instr(2, 8, "SET 2, E", {})
    op[0xD4] = Instr(2, 8, "SET 2, H", {})
    op[0xD5] = Instr(2, 8, "SET 2, L", {})
    op[0xD6] = Instr(2, 16, "SET 2, (HL)", {})
    op[0xD7] = Instr(2, 8, "SET 2, A", {})
    op[0xD8] = Instr(2, 8, "SET 3, B", {})
    op[0xD9] = Instr(2, 8, "SET 3, C", {})
    op[0xDA] = Instr(2, 8, "SET 3, D", {})
    op[0xDB] = Instr(2, 8, "SET 3, E", {})
    op[0xDC] = Instr(2, 8, "SET 3, H", {})
    op[0xDD] = Instr(2, 8, "SET 3, L", {})
    op[0xDE] = Instr(2, 16, "SET 3, (HL)", {})
    op[0xDF] = Instr(2, 8, "SET 3, A", {})
    op[0xE0] = Instr(2, 8, "SET 4, B", {})
    op[0xE1] = Instr(2, 8, "SET 4, C", {})
    op[0xE2] = Instr(2, 8, "SET 4, D", {})
    op[0xE3] = Instr(2, 8, "SET 4, E", {})
    op[0xE4] = Instr(2, 8, "SET 4, H", {})
    op[0xE5] = Instr(2, 8, "SET 4, L", {})
    op[0xE6] = Instr(2, 16, "SET 4, (HL)", {})
    op[0xE7] = Instr(2, 8, "SET 4, A", {})
    op[0xE8] = Instr(2, 8, "SET 5, B", {})
    op[0xE9] = Instr(2, 8, "SET 5, C", {})
    op[0xEA] = Instr(2, 8, "SET 5, D", {})
    op[0xEB] = Instr(2, 8, "SET 5, E", {})
    op[0xEC] = Instr(2, 8, "SET 5, H", {})
    op[0xED] = Instr(2, 8, "SET 5, L", {})
    op[0xEE] = Instr(2, 16, "SET 5, (HL)", {})
    op[0xEF] = Instr(2, 8, "SET 5, A", {})
    op[0xF0] = Instr(2, 8, "SET 6, B", {})
    op[0xF1] = Instr(2, 8, "SET 6, C", {})
    op[0xF2] = Instr(2, 8, "SET 6, D", {})
    op[0xF3] = Instr(2, 8, "SET 6, E", {})
    op[0xF4] = Instr(2, 8, "SET 6, H", {})
    op[0xF5] = Instr(2, 8, "SET 6, L", {})
    op[0xF6] = Instr(2, 16, "SET 6, (HL)", {})
    op[0xF7] = Instr(2, 8, "SET 6, A", {})
    op[0xF8] = Instr(2, 8, "SET 7, B", {})
    op[0xF9] = Instr(2, 8, "SET 7, C", {})
    op[0xFA] = Instr(2, 8, "SET 7, D", {})
    op[0xFB] = Instr(2, 8, "SET 7, E", {})
    op[0xFC] = Instr(2, 8, "SET 7, H", {})
    op[0xFD] = Instr(2, 8, "SET 7, L", {})
    op[0xFE] = Instr(2, 16, "SET 7, (HL)", {})
    op[0xFF] = Instr(2, 8, "SET 7, A", {})
}
