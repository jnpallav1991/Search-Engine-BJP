package com.adromindts.bjp.view.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import com.adromindts.bjp.R
import com.adromindts.bjp.model.PeopleModel
import kotlinx.android.synthetic.main.custom_alert_dialog.*
import kotlinx.android.synthetic.main.custom_alert_dialog.view.*
import kotlinx.android.synthetic.main.custom_alert_dialog.view.serNo

class
CustomAlertDialog(context: Context, check: Boolean) : AlertDialog(context) {

    private val TAG = CustomAlertDialog::class.java.simpleName

    /**
     * Creating and returns single instance
     *
     * @return
     */
    companion object {

        fun newInstance(
            context: Context

        ): CustomAlertDialog {

            val alertDialog = CustomAlertDialog(context)
            alertDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            return alertDialog
        }
    }

    constructor(context: Context) : this(context, true) {
        //setContentView(R.layout.custom_alert_dialog);
        // Get the layout inflater
        val inflater = layoutInflater
        // Inflate and set the layout for the dialog
        val view = inflater.inflate(R.layout.custom_alert_dialog, null)
        setView(view)
        setCancelable(false)

        try {
            view.positiveButton!!.setOnClickListener {
                dismiss()
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }


        show()
    }

    fun showDetails(people: PeopleModel.Sheet) {
        if (people.SrNo.isNullOrEmpty())
        {
            serNo.visibility = View.GONE
            tvSerNo.visibility = View.GONE
        }
        else
        {
            serNo.visibility = View.VISIBLE
            serNo.text =people.SrNo
            tvSerNo.visibility = View.VISIBLE
        }
        nameOfElector.text =people.NameOfElector

        if (people.RelativeName.isNullOrEmpty())
        {
            relativeName.visibility = View.GONE
            tvRelativeName.visibility = View.GONE
        }
        else
        {
            relativeName.visibility = View.VISIBLE
            tvRelativeName.visibility = View.VISIBLE
            relativeName.text =people.RelativeName
        }

        if (people.Address.isNullOrEmpty())
        {
            address.visibility = View.GONE
            tvAddress.visibility = View.GONE
        }
        else
        {
            address.visibility = View.VISIBLE
            tvAddress.visibility = View.VISIBLE
            address.text =people.Address
        }

        if (people.Qualification.isNullOrEmpty())
        {
            qualification.visibility = View.GONE
            tvQualification.visibility = View.GONE
        }
        else
        {
            qualification.visibility = View.VISIBLE
            tvQualification.visibility = View.VISIBLE
            qualification.text =people.Qualification
        }
        if (people.Occupation.isNullOrEmpty())
        {
            occupation.visibility = View.GONE
            tvOccupation.visibility = View.GONE
        }
        else
        {
            occupation.visibility = View.VISIBLE
            tvOccupation.visibility = View.VISIBLE
            occupation.text =people.Occupation
        }

        if (people.Age.isNullOrEmpty())
        {
            age.visibility = View.GONE
            tvAge.visibility = View.GONE
        }
        else
        {
            age.visibility = View.VISIBLE
            tvAge.visibility = View.VISIBLE
            age.text =people.Age
        }

        if (people.EPICNo.isNullOrEmpty())
        {
            ePICNo.visibility = View.GONE
            tvEPICNo.visibility = View.GONE
        }
        else
        {
            ePICNo.visibility = View.VISIBLE
            tvEPICNo.visibility = View.VISIBLE
            ePICNo.text =people.EPICNo
        }


        if (people.GPART_NO.isNullOrEmpty())
        {
            gPartNo.visibility = View.GONE
            tvGpartNo.visibility = View.GONE
        }
        else
        {
            gPartNo.visibility = View.VISIBLE
            tvGpartNo.visibility = View.VISIBLE
            gPartNo.text =people.GPART_NO
        }

        if (people.NameOfElectorMarathi.isNullOrEmpty())
        {
            nameOfElectorMarathi.visibility = View.GONE
            tvNameOfElectorMarathi.visibility = View.GONE
        }
        else
        {
            nameOfElectorMarathi.visibility = View.VISIBLE
            tvNameOfElectorMarathi.visibility = View.VISIBLE
            nameOfElectorMarathi.text =people.NameOfElectorMarathi
        }

        if (people.CCODE.isNullOrEmpty())
        {
            Ccode.visibility = View.GONE
            tvCCode.visibility = View.GONE
        }
        else
        {
            Ccode.visibility = View.VISIBLE
            tvCCode.visibility = View.VISIBLE
            Ccode.text =people.CCODE
        }

        if (people.Gender.isNullOrEmpty())
        {
            gender.visibility = View.GONE
            tvGender.visibility = View.GONE
        }
        else
        {
            gender.visibility = View.VISIBLE
            tvGender.visibility = View.VISIBLE
            gender.text =people.Gender
        }
    }

}