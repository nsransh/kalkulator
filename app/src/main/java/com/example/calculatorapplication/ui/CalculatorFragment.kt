package com.example.calculatorapplication.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.calculatorapplication.R
import com.example.calculatorapplication.databinding.FragmentCalculatorBinding
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat
import kotlin.math.*

class CalculatorFragment : Fragment() {

    private lateinit var binding: FragmentCalculatorBinding
    private lateinit var scientificFragment: ScientificFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scientificFragment = ScientificFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCalculatorBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            llSci.isVisible = false
            tvAngka.layoutParams.height = 700

            //===========SCI============
            btnSci.setOnClickListener {
                tvAngka.layoutParams.height = 480
                llSci.isVisible = true
                btnSci.isEnabled = false
            }

            btnCancel.setOnClickListener {
                llSci.isVisible = false
                btnSci.isEnabled = true
                tvAngka.layoutParams.height = 700
            }
            btnSin.setOnClickListener {
                var result = 0.0
                if (tvAngka.text.isNotEmpty()){
                    result = calculates()
                }
                val sin = sin(Math.toRadians(result))
                if (sin.isNaN()){
                    tvAngka.hint = DecimalFormat("0.######").format(sin).toString()
                }else {
                    tvAngka.text = DecimalFormat("0.######").format(sin).toString()
                }
            }
            btnCos.setOnClickListener {
                var result = 0.0
                if (tvAngka.text.isNotEmpty()){
                    result = calculates()
                }
                val cos = cos(Math.toRadians(result))
                if (cos.isNaN()){
                    tvAngka.hint = DecimalFormat("0.######").format(cos).toString()
                }else {
                    tvAngka.text = DecimalFormat("0.######").format(cos).toString()
                }
            }
            btnTan.setOnClickListener {
                var result = 0.0
                if (tvAngka.text.isNotEmpty()){
                    result = calculates()
                }
                val tan = tan(Math.toRadians(result))
                if (tan.isNaN()){
                    tvAngka.hint = DecimalFormat("0.######").format(tan).toString()
                }else {
                    tvAngka.text = DecimalFormat("0.######").format(tan).toString()
                }
            }
            btnPersen.setOnClickListener {
                var result = 0.0
                if (tvAngka.text.isNotEmpty()){
                    result = calculates()
                }
                val persen = result/100
                Log.e("persen", "$persen")
                tvAngka.text = DecimalFormat("0.######").format(persen).toString()
            }
            //=============================

            //====Add Angka=====
            btn0.setOnClickListener {
                tvAngka.text = tvAngka.text.toString() + "0"
            }
            btn1.setOnClickListener {
                tvAngka.text = tvAngka.text.toString() + "1"
            }
            btn2.setOnClickListener {
                tvAngka.text = tvAngka.text.toString() + "2"
            }
            btn3.setOnClickListener {
                tvAngka.text = tvAngka.text.toString() + "3"
            }
            btn4.setOnClickListener {
                tvAngka.text = tvAngka.text.toString() + "4"
            }
            btn5.setOnClickListener {
                tvAngka.text = tvAngka.text.toString() + "5"
            }
            btn6.setOnClickListener {
                tvAngka.text = tvAngka.text.toString() + "6"
            }
            btn7.setOnClickListener {
                tvAngka.text = tvAngka.text.toString() + "7"
            }
            btn8.setOnClickListener {
                tvAngka.text = tvAngka.text.toString() + "8"
            }
            btn9.setOnClickListener {
                tvAngka.text = tvAngka.text.toString() + "9"
            }
            btnKoma.setOnClickListener {
                val cek = tvAngka.text.toString()
                if (cek.isNotEmpty()){
                    if (!cek.get(index=cek.length-1).toString().equals("/") && !cek.get(index=cek.length-1).toString().equals("*") && !cek.get(index=cek.length-1).toString().equals("+") && !cek.get(index=cek.length-1).toString().equals("-")){
                        tvAngka.text = tvAngka.text.toString() + "."
                    }else{
                        Toast.makeText(requireContext(), "Input Salah, Harus Angka Dulu", Toast.LENGTH_LONG).show()
                    }
                } else {
                    tvAngka.text = tvAngka.text.toString() + "0."
                }
            }
            //=======================================
            btnDel.setOnClickListener {
                tvAngka.text = tvAngka.text.toString().dropLast(1)
            }
            btnAc.setOnClickListener {
                tvAngka.text = ""
                tvAngka.hint = "0"
            }

            //=========kalkulasi =======
            btnDiv.setOnClickListener {
                val cek = tvAngka.text.toString()
                if (cek.isNotEmpty()){
                    if (!cek.get(index=cek.length-1).toString().equals("/") && !cek.get(index=cek.length-1).toString().equals("*") && !cek.get(index=cek.length-1).toString().equals("+") && !cek.get(index=cek.length-1).toString().equals("-")){
                        tvAngka.text = tvAngka.text.toString() + "/"
                    }else{
                        Toast.makeText(requireContext(), "Input Salah, Harus Angka Dulu", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(requireContext(), "Input Salah, Harus Angka Dulu", Toast.LENGTH_LONG).show()
                }
            }
            btnPwr.setOnClickListener {
                val cek = tvAngka.text.toString()
                if (cek.isNotEmpty()){
                    if (!cek.get(index=cek.length-1).toString().equals("/") && !cek.get(index=cek.length-1).toString().equals("*") && !cek.get(index=cek.length-1).toString().equals("+") && !cek.get(index=cek.length-1).toString().equals("-")){
                        tvAngka.text = tvAngka.text.toString() + "*"
                    } else{
                        Toast.makeText(requireContext(), "Input Salah, Harus Angka Dulu", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(requireContext(), "Input Salah, Harus Angka Dulu", Toast.LENGTH_LONG).show()
                }
            }
            btnPlus.setOnClickListener {
                val cek = tvAngka.text.toString()
                if (cek.isNotEmpty()){
                    if (!cek.get(index=cek.length-1).toString().equals("/") && !cek.get(index=cek.length-1).toString().equals("*") && !cek.get(index=cek.length-1).toString().equals("+") && !cek.get(index=cek.length-1).toString().equals("-")){
                        tvAngka.text = tvAngka.text.toString() + "+"
                    } else {
                        Toast.makeText(requireContext(), "Input Salah, Harus Angka Dulu", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(requireContext(), "Input Salah, Harus Angka Dulu", Toast.LENGTH_LONG).show()
                }
            }
            btnMinus.setOnClickListener {
                val cek = tvAngka.text.toString()
                if (cek.isNotEmpty()){
                    if (!cek.get(index=cek.length-1).toString().equals("/") && !cek.get(index=cek.length-1).toString().equals("*") && !cek.get(index=cek.length-1).toString().equals("+") && !cek.get(index=cek.length-1).toString().equals("-")){
                        tvAngka.text = tvAngka.text.toString() + "-"
                    } else {
                        Toast.makeText(requireContext(), "Input Salah, Harus Angka Dulu", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(requireContext(), "Input Salah, Harus Angka Dulu", Toast.LENGTH_LONG).show()
                }
            }
            btnEqual.setOnClickListener {
                showResult()
            }
        }
    }

    private fun getInputExpression(): String {
        var expression = binding.tvAngka.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun calculates() : Double{
        val expression = getInputExpression()
        val result = Expression(expression).calculate()
        return result
    }

    private fun showResult() {
        try {
            val result = calculates()
            Log.e("cek kalkulasi hasil", "${result}")
            if (result.isNaN()) {
                // Show Error Message
                binding.tvAngka.text = "Error"
            } else {
                // Show Result
                binding.tvAngka.text = DecimalFormat("0.######").format(result).toString()
            }
        } catch (e: Exception) {
            // Show Error Message
            binding.tvAngka.text = "Error"
        }
    }



    companion object {

        fun newInstance(param1: String, param2: String) =
            CalculatorFragment()
    }
}