package com.baptistecarlier.am24.ui.feature.detail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.baptistecarlier.am24.R
import com.baptistecarlier.am24.shared.domain.model.GoatDetail

@Composable
internal fun SkillCard(state: GoatDetail) {
    if (state.skills?.milkProductivity != null ||
        state.skills?.friendliness != null ||
        state.skills?.humor != null
    ) {
        Card {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                SkillRow(state.skills?.milkProductivity,
                    stringResource(R.string.detail_milkproductivity))
                SkillRow(state.skills?.friendliness, stringResource(R.string.detail_friendliness))
                SkillRow(state.skills?.humor, stringResource(R.string.detail_humor))
            }
        }
    }
}
